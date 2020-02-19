package com.minidwep.springboot04.config;


import com.minidwep.springboot04.component.LoginHandleInterceptor;
import com.minidwep.springboot04.component.MyLocaleResolver;
//import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
//@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {
    //视图解析器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("main.html").setViewName("dashboard");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        静态资源 *.css *.js
//        SpringBoot已经做好了静态资源映射
//        registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/**")
//        .excludePathPatterns("/index.html","/","/user/login","/webjars/**","/asserts/**");
//        registry.addInterceptor(new LoginHandleInterceptor())
//                .excludePathPatterns("/index.html","/","/user/login","/webjars/**","/asserts/**");

    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//静态文件
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/public/");
//webjar文件
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }


    //改写国际化组件
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }




}
