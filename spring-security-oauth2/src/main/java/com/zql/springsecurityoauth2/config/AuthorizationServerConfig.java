package com.zql.springsecurityoauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private static final String DEMO_RESOURCE_ID = "order";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 明文存储
//        String finalSecret = "123456";
        // 使用BCrypt对密码编码
//        String finalSecret = new BCryptPasswordEncoder().encode("123456");
        // 通过前缀标注编码
        String finalSecret = "{bcrypt}" + new BCryptPasswordEncoder().encode("123456");

        // 配置两个客户端，一个用password认证，一个用于clients认证
        clients.inMemory()
            .withClient("client_1")
            .resourceIds(DEMO_RESOURCE_ID)
            .authorizedGrantTypes("client_credentials","refresh_token")
            .scopes("select")
            .authorities("oauth2")
            .secret(finalSecret)
            .and()
            .withClient("client_2")
            .resourceIds(DEMO_RESOURCE_ID)
            .authorizedGrantTypes("password","refresh_token")
            .scopes("select")
            .authorities("oauth2")
            .secret(finalSecret);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
            .tokenStore(new RedisTokenStore(redisConnectionFactory))
            .allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST)
            .authenticationManager(authenticationManager);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();   // 允许表单认证
    }
}
