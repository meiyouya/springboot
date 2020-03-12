package com.zql.design.pattern;

import com.zql.design.pattern.factory.UserPayServiceStrategyFactory;
import com.zql.design.pattern.strategy.UserPayService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

/**
 * @author lawliet.L
 */
@SpringBootApplication
public class DesignPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternApplication.class, args);

        Integer level = 3;
        BigDecimal price = BigDecimal.valueOf(10);
        UserPayService userPayService = UserPayServiceStrategyFactory.getStrategyByUserLevel(level);
        System.out.println(userPayService.calcPrice(price));
    }

}
