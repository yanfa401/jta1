package com.xielei.jta1.config;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.hibernate.engine.transaction.jta.platform.internal.AbstractJtaPlatform;

/**
 * 描述：由于spring没有为jpa提供jta管理注入,所以需要手工配置一个JtaPlatfom
 *
 * @author xielei
 * @date 2019/07/30
 */
public class AtomikosJtaPlatform extends AbstractJtaPlatform {
    
    private static final long serialVersionUID = 1L;
    
    static TransactionManager transactionManager;
    
    static UserTransaction transaction;
    
    @Override
    protected TransactionManager locateTransactionManager() {
        return transactionManager;
    }
    
    @Override
    protected UserTransaction locateUserTransaction() {
        return transaction;
    }
}
