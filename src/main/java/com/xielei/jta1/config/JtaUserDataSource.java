package com.xielei.jta1.config;

import java.sql.SQLException;
import java.util.HashMap;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;

/**
 * 描述：
 *
 * @author xielei
 * @date 2019/07/30
 */
@Configuration
@DependsOn("transactionManager")
@EnableJpaRepositories(basePackages = {"com.xielei.jta1.repository"},// 用于扫描持久层
        entityManagerFactoryRef = "userEntityManager", // 实体管理工厂
        transactionManagerRef = "transactionManager") // 事物管理器
@EnableConfigurationProperties(UserProperties.class)
public class JtaUserDataSource {
    
    //注入user数据源信息
    @Autowired
    private UserProperties userProperties;
    
    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;
    
    /**
     * user数据源
     * @return
     * @throws SQLException
     */
    @Bean(name = "userDataSource")
    public DataSource userDataSource() throws SQLException {
        // 新建数据源，并将数据源配置信息装置
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setURL(userProperties.getUrl());
        mysqlXADataSource.setUser(userProperties.getUsername());
        mysqlXADataSource.setPassword(userProperties.getPassword());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setUniqueResourceName("userDataSource");
        
        return xaDataSource;
    }
    
    
    /**
     * user库的实体管理器
     * @return
     * @throws Throwable
     */
    @Bean(name = "userEntityManager")
    @DependsOn("transactionManager")
    public LocalContainerEntityManagerFactoryBean computerEntityManager() throws Throwable {
        
        HashMap<String, Object> properties = new HashMap();
        properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");
        
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJtaDataSource(userDataSource());
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
        entityManager.setPackagesToScan("com.xielei.jta1.entity");
        entityManager.setPersistenceUnitName("userPersistenceUnit");
        entityManager.setJpaPropertyMap(properties);
        return entityManager;
    }
}
