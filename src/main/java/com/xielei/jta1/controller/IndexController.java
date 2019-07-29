package com.xielei.jta1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xielei.jta1.entity.User;
import com.xielei.jta1.entity2.Prod;
import com.xielei.jta1.service.MergeService;
import com.xielei.jta1.service.ProdService;
import com.xielei.jta1.service.UserService;

/**
 * 描述：
 *
 * @author xielei
 * @date 2019/07/28
 */

@RestController
@RequestMapping("/index")
public class IndexController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProdService prodService;
    
    @Autowired
    private MergeService mergeService;
    
    @GetMapping("findAll")
    public List<User> findAll() {
        return userService.findAll();
    }
    
    
    @GetMapping("findAllProd")
    public List<Prod> findAllProd() {
        return prodService.findAll();
    }
    
    
    @GetMapping("merge")
    public void merge(){
        mergeService.insert();
    }
    
}
