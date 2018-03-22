package com.hfcsbc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangyunfei on 2017/6/12.
 */
@Configuration
@EnableResourceServer
// @EnableResourceServer Oauth2 资源服务器的便利方法，开启了一个spring security的filter，这个filter通过一个Oauth2的token进行认证请求。使用者应该增加这个注解，并提供一个ResourceServerConfigurer类型的Bean(例如通过ResouceServerConfigurerAdapter)来指定资源(url路径和资源id)的细节。为了利用这个filter，你必须在你的应用中的某些地方EnableWebSecurity，或者使用这个注解的地方，或者其他别的地方。
//@EnableResourceServer 这个注解创建了一个WebSecurityConfigurerAdapter，且自带了硬编码的order=3.在spring中，由于技术原因不能立即改变order的顺序，因此你必须在你的spring应用中避免使用order=3的其他WebSecurityConfigurerAdapter。
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
