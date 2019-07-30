package com.xielei.jta1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.xielei.jta1.config.ProdProperties;
import com.xielei.jta1.config.UserProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {UserProperties.class, ProdProperties.class})
public class Jta1Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Jta1Application.class, args);
    }
    
}
