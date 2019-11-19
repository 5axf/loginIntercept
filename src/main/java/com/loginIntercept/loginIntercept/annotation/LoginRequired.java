package com.loginIntercept.loginIntercept.annotation;

import java.lang.annotation.*;

/**
 * 自定义登录注解，在方法上有这个注解的需要进行登录判断
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LoginRequired {
}
