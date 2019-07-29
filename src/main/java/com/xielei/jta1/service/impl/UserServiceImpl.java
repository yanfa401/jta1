package com.xielei.jta1.service.impl;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xielei.jta1.entity.User;
import com.xielei.jta1.repository.UserRepository;
import com.xielei.jta1.service.UserService;

/**
 * 描述：
 *
 * @author xielei
 * @date 2019/07/28
 */

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    
    @Transactional
    @Override
    public List<User> findAll() {
        User user = new User();
        user.setId(new Random().nextInt(Integer.MAX_VALUE));
        user.setName(UUID.randomUUID().toString().substring(0,6));
        user.setAge(new Random().nextInt(100));
        userRepository.save(user);
        return userRepository.findAll();
    }
}
