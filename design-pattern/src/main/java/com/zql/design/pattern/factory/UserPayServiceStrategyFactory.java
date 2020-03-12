package com.zql.design.pattern.factory;

import com.zql.design.pattern.strategy.UserPayService;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lawliet.L
 */
public class UserPayServiceStrategyFactory {

    private static Map<Integer, UserPayService> factory = new ConcurrentHashMap<>();

    public static UserPayService getStrategyByUserLevel(Integer level) {
        return factory.get(level);
    }

    public static void registerStrategy(Integer level, UserPayService service) {
        Assert.notNull(level, "用户等级不能为null");
        factory.put(level, service);
    }
}
