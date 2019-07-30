package com.xielei.jta1.config;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

/**
 * 描述：
 *
 * @author xielei
 * @date 2019/07/30
 */

@Configuration
@EnableTransactionManagement
public class MainConfig {
    
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    
    /**
     * 设置jpa的特性
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        //显示sql
        hibernateJpaVendorAdapter.setShowSql(true);
        //自动生成表或更新表
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        //设置数据源类型
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }
    
    
    @Bean(name = "userTransaction")
    public UserTransaction userTransaction() throws Throwable {
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        userTransactionImp.setTransactionTimeout(10000);
        return userTransactionImp;
    }
    
    
    /**
     * 供给 PlatformTransactionManager使用
     * @return
     * @throws Throwable
     */
    @Bean(name = "atomikosTransactionManager")
    public TransactionManager atomikosTransactionManager() throws Throwable {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);
        
        AtomikosJtaPlatform.transactionManager = userTransactionManager;
        
        return userTransactionManager;
    }
    
    /**
     * Atomikos事务管理器,用于管理多个数据源的事务
     * @return
     * @throws Throwable
     */
    @Bean(name = "transactionManager")
    @DependsOn({ "userTransaction", "atomikosTransactionManager" })
    public PlatformTransactionManager transactionManager() throws Throwable {
        UserTransaction userTransaction = userTransaction();
        
        AtomikosJtaPlatform.transaction = userTransaction;
        
        TransactionManager atomikosTransactionManager = atomikosTransactionManager();
        return new JtaTransactionManager(userTransaction, atomikosTransactionManager);
    }
    
}
