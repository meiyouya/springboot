package com.zql.design.pattern.strategy;

import java.math.BigDecimal;

/**
 * @author lawliet.L
 */
public interface UserPayService {

    /**
     * 计算用户的应付金额
     * @return
     */
    BigDecimal calcPrice(BigDecimal price);
}
