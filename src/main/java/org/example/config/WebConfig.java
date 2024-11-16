package org.example.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("org.example.controllers")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    private final Environment environment;

    public WebConfig(Environment environment) {
        this.environment = environment;
    }

//    @Autowired
//    Environment environment;

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
        viewResolver.setSuffix(".jsp");
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resource/**").addResourceLocations("/resource/");
    }

//    @Bean
//    public Logger logger(){
//        Logger logger= Logger.getLogger(WebConfig.class);
//        return logger;
//    }

    @Bean
    @Scope("prototype")
    public Logger produceLogger(InjectionPoint injectionPoint){
        Class<?> classOnWired= injectionPoint.getMember().getDeclaringClass();
        return Logger.getLogger(classOnWired);
    }



}
