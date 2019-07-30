package com.xielei.jta1.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * 描述：
 *
 * @author xielei
 * @date 2019/07/29
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.user")
public class UserProperties {

    private String url;
    
    private String username;
    
    private String password;
    
}
