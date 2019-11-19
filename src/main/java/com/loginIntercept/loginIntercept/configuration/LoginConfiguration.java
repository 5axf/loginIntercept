package com.loginIntercept.loginIntercept.configuration;

import com.loginIntercept.loginIntercept.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfiguration implements WebMvcConfigurer {

    /**
     * 将自定义的拦截器添加到springboot中
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//需要拦截的路径
                .excludePathPatterns();//不需要拦截的路径，如index.html,login.html,register.html
    }
}
