package com.zql.mybatisplus.service;

import com.zql.mybatisplus.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lawliet
 * @since 2019-04-20
 */
public interface IUserService extends IService<User> {

    @Transactional
    boolean deleteBatch();
}
