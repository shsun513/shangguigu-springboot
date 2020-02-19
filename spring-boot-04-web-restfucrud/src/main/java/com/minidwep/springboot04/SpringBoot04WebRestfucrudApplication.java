package com.minidwep.springboot04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringBoot04WebRestfucrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot04WebRestfucrudApplication.class, args);

    }

    @Bean
    public ViewResolver myViewReolver(){
        return new MyViewResolver();
    }

    public static  class MyViewResolver implements ViewResolver{

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }

}
