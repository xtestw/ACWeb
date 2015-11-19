package com.cquacmer.task.count;

import com.cquacmer.dao.IACRecordDao;
import com.cquacmer.dao.IUserDao;
import com.cquacmer.model.ACRecord;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015/11/18.
 */
public abstract class BaseOpreation{
    public IUserDao getUserDao() {
        return userDao;
    }

    @Resource
    public void setUserDao(IUserDao userDao) {
        System.out.println("df");
        this.userDao = userDao;
    }

    protected IUserDao userDao;

    public IACRecordDao getAcRecordDao() {
        return acRecordDao;
    }

    @Resource
    public void setAcRecordDao(IACRecordDao acRecordDao) {
        this.acRecordDao = acRecordDao;
    }

    protected  List<String> accounts;
    protected  ArrayList<ACRecord> records;
    public BaseOpreation(){
        accounts=new ArrayList<String>();
        records=new ArrayList<ACRecord>();
    }

    protected IACRecordDao acRecordDao;
    public abstract void ReadAccount();
    public abstract void Query();
    public void InsertOrUpdateDatabase() {
        for(ACRecord item:records){
            acRecordDao.saveOrUpdate(item);
        }
    }
}
