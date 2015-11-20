package com.cquacmer.service;

import com.cquacmer.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by admin on 2015/11/20.
 */
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
// defaultRollback=true不会改变数据库，false会改变数据库
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class loginTest {
    @Resource
    private ILoginService loginService;
    @Test
    public void Test(){
        User u=new User();
        u.setUsername("xtestw");
        System.out.println(loginService.isExist("xtestw"));
        System.out.println(loginService.checkPassword(u));

    }
}
