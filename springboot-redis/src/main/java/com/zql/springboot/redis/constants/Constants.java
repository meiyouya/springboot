package com.zql.springboot.redis.constants;

/**
 * @author lawliet.L
 */
public interface Constants {

    interface Redis {
        String IDEMPOTENT_TOKEN_PREFIX = "idempotent_token_";
    }

    interface Token {
        String HEADER_TOKEN_NAME = "check_idempotent";
    }
}
