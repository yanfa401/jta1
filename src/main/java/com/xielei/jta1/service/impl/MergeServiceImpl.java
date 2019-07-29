package com.xielei.jta1.service.impl;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xielei.jta1.entity.User;
import com.xielei.jta1.entity2.Prod;
import com.xielei.jta1.repository.UserRepository;
import com.xielei.jta1.repository2.ProdRepository;
import com.xielei.jta1.service.MergeService;

/**
 * 描述：
 *
 * @author xielei
 * @date 2019/07/29
 */
@Service
public class MergeServiceImpl implements MergeService {
    
    @Autowired
    private ProdRepository prodRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Transactional
    @Override
    public void insert() {
    
        User user = new User();
        user.setId(new Random().nextInt(Integer.MAX_VALUE));
        user.setName(UUID.randomUUID().toString().substring(0,6));
        user.setAge(new Random().nextInt(100));
        userRepository.save(user);
    
        Prod prod = new Prod();
        prod.setId(new Random().nextInt(Integer.MAX_VALUE));
        prod.setName(UUID.randomUUID().toString().substring(0,6));
        prodRepository.save(prod);
        
        
        int i = 1/0;
        
        
    }
}
