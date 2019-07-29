package com.xielei.jta1.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 描述：数据源的配置类
 *
 * @author xielei
 * @date 2019/07/28
 */

@Configuration
public class DataSourceConfig {
    
    /**
     * 第一个数据源配置
     * @return
     */
    @Primary
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    /**
     * 第二个数据源配置
     * @return
     */
    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    
    /*@Bean("transactionManager")
    public DataSourceTransactionManager getTransactionManager( @Qualifier("primaryDataSource")DataSource ds1){
        return new DataSourceTransactionManager(ds1);
    }*/
    
}
