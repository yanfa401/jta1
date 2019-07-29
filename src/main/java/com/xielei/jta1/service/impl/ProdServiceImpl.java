package com.xielei.jta1.service.impl;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xielei.jta1.entity2.Prod;
import com.xielei.jta1.repository2.ProdRepository;
import com.xielei.jta1.service.ProdService;

/**
 * 描述：
 *
 * @author xielei
 * @date 2019/07/29
 */
@Service
public class ProdServiceImpl implements ProdService {
    
    @Autowired
    private ProdRepository prodRepository;
    
    @Override
    @Transactional
    public List<Prod> findAll() {
        Prod prod = new Prod();
        prod.setId(new Random().nextInt(Integer.MAX_VALUE));
        prod.setName(UUID.randomUUID().toString().substring(0,6));
        prodRepository.save(prod);
        return prodRepository.findAll();
    }
    
}
