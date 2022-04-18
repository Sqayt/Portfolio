package com.example.demo.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/v1336/authentication").setViewName("authentication");
        registry.addViewController("/v1336/news").setViewName("news");
  //      registry.addViewController("/v1336/registration").setViewName("registration");
    }
}
