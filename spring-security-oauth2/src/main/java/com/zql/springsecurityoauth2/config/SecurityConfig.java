package com.zql.springsecurityoauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 替换UserDetailsService方式
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        // 明文存储
//        String finalSecret = "123456";
        // 使用BCrypt对密码编码
//        String finalSecret = new BCryptPasswordEncoder().encode("123456");
        // 通过前缀标注编码
        String finalSecret = "{bcrypt}" + bCryptPasswordEncoder.encode("123456");

        InMemoryUserDetailsManager memoryUserManage = new InMemoryUserDetailsManager();
        memoryUserManage.createUser(User.withUsername("user_1").password(finalSecret).authorities("USER").build());
        memoryUserManage.createUser(User.withUsername("user_2").password(finalSecret).authorities("USER").build());
        return memoryUserManage;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().anyRequest()
          .and()
          .authorizeRequests()
          .antMatchers("/oauth/**").permitAll()
          .and().csrf().disable();  // 禁用Spring Security自带的跨域处理
    }

    // 替换AuthenticationManager方式
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()   // 这里为了方便，配置使用内存管理用户名密码，实际环境肯定是使用数据库
          .withUser("user1").password("{noop}123456").authorities("USER")
          .and()
          .withUser("user2").password("{noop}123456").authorities("USER");
    }*/

    /**
     * 这个配置是必不可少的，否则SpringBoot会自动配置一个AuthenticationManager,覆盖掉内存中的用户
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 密码编码方式
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        // return NoOpPasswordEncoder.getInstance();   // 明文存储密码时使用
        // return new BCryptPasswordEncoder();      // 使用BCrypt时使用
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();  // 通过前缀自动区分编码方式
    }
}
