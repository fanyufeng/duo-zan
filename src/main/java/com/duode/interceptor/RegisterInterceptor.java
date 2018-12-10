package com.duode.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fanyufeng on 2018/11/25
 */

public class RegisterInterceptor extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir =registry.addInterceptor(new LoginInterceptor());
        ir.excludePathPatterns("/user/hello");
        ir.excludePathPatterns("/user/register");
        super.addInterceptors(registry);
    }
}
