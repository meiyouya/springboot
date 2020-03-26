package com.zql.springboot.redis.idempotent;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.zql.springboot.redis.constants.Constants;
import com.zql.springboot.redis.util.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lawliet.L
 */
@Service
@Slf4j
public class TokenService {

    @Autowired
    private RedisService redisService;

    /**
     * 创建token
     * @return
     */
    public String createToken() {
        String uuid = UUID.fastUUID().toString();
        StringBuilder token = new StringBuilder();
        try {
            token.append(Constants.Redis.IDEMPOTENT_TOKEN_PREFIX).append(uuid.replace("-", "").toUpperCase());
            // 2小时候自动到期，防止未正常删除
            redisService.setKeyAndExpire(token.toString(), token.toString(), 7200L);
        } catch (Exception e) {
            log.error("创建token失败", e);
            return null;
        }
        return token.toString();
    }

    /**
     * 校验token
     * @param request
     * @return
     */
    public boolean checkToken(HttpServletRequest request) {
        String headerToken = request.getHeader(Constants.Token.HEADER_TOKEN_NAME);
        if (StrUtil.isEmpty(headerToken)) {
            return false;
        }
        if (!redisService.exists(headerToken)) {
            return false;
        }
        if (!redisService.remove(headerToken)) {
            return false;
        }
        return true;
    }
}
