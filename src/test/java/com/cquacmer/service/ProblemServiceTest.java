package com.cquacmer.service;

import com.cquacmer.model.Problem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by admin on 2015/12/8.
 */@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-hibernate.xml"})
   @RunWith(SpringJUnit4ClassRunner.class)
// defaultRollback=true不会改变数据库，false会改变数据库
   @TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
   @Transactional
public class ProblemServiceTest {
    @Resource
    private IProblemService problemService;

    @Test
    public void addProblemTest(){
        Problem p=new Problem();
        p.setTags("DP");
        p.setOjName("HUST");
        p.setOjId("1002");
        p.setLevel("水题");
        problemService.add(p);
        System.out.println(p.getId());
    }
}
