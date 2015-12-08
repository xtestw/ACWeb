package com.cquacmer.service;

import com.cquacmer.model.Summary;
import com.cquacmer.model.User;
import net.sf.ehcache.search.aggregator.Sum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2015/12/8.
 */
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
// defaultRollback=true不会改变数据库，false会改变数据库
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class SummaryServiceTest {
    @Resource
    private  ISummaryService summaryService;

    @Test
    public void testAddSummary(){
        Summary summary=new Summary();
        User u=new User();
        u.setId(1);
        summary.setAuthor(u);
        summary.setContent("23323");
        summary.setState(1);
        summary.setTitle("2323");
        summaryService.add(summary);
    }

    @Test
    public void testFindByUid(){
       List<Summary> ret= summaryService.getListByUid(1);
       System.out.println(ret.size());
    }
}
