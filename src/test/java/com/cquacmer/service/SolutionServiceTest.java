package com.cquacmer.service;

import com.cquacmer.dao.ISolutionDao;
import com.cquacmer.model.Problem;
import com.cquacmer.model.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2015/11/22.
 */
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
// defaultRollback=true不会改变数据库，false会改变数据库
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class SolutionServiceTest {
    @Resource
    private ISolutionService solutionService;
    @Resource
    private ISolutionDao solutionDao;

    @Test
    public void query(){
        Problem p= solutionService.list("1");
        System.out.println(p.getSolutions().size());
        List<Solution> solutionList= solutionDao.findList("from Solution where pid=?",1);
        System.out.println(solutionList.size());
        Solution s=new Solution();
        s.setUsername("@2");
        s.setSolution("33333");
        s.setProblem(p);
        p.getSolutions().add(s);
    }
}
