package com.cquacmer.dao;

import com.cquacmer.dao.impl.ACRecordDao;
import com.cquacmer.model.ACRecord;
import com.cquacmer.model.User;
import com.cquacmer.task.count.codeforces.CODEFORCES;
import com.cquacmer.task.count.fzu.FZU;
import com.cquacmer.task.count.hdu.HDU;
import com.cquacmer.task.count.hust.HUST;
import com.cquacmer.task.count.poj.POJ;
import com.cquacmer.task.count.zoj.ZOJ;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2015/11/18.
 */

@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
// defaultRollback=true不会改变数据库，false会改变数据库
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class acrecord {

    public IUserDao getUserDao() {

        return userDao;
    }

    @Resource
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    private IUserDao userDao;

    @Resource(name="aCRecordDao")
    private IACRecordDao acRecordDao;

    @Test
    public void test(){
        CODEFORCES fzu=new CODEFORCES();
        fzu.setUserDao(userDao);
        fzu.setAcRecordDao(acRecordDao);
        fzu.run();
        List<User> p=userDao.findList("from User");
        for(User u : p){
            System.out.println(u.getHust_name());
        }
    }
}
