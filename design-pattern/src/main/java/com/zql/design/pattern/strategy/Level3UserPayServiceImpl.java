package com.zql.design.pattern.strategy;

import com.zql.design.pattern.factory.UserPayServiceStrategyFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author lawliet.L
 */
@Service
public class Level3UserPayServiceImpl implements UserPayService, InitializingBean {
    /**
     * 计算用户的应付金额
     *
     * @param price
     * @return
     */
    @Override
    public BigDecimal calcPrice(BigDecimal price) {
        return price.multiply(BigDecimal.valueOf(0.5));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        UserPayServiceStrategyFactory.registerStrategy(3, this);
    }
}
