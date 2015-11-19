package com.cquacmer.dao.impl;

import com.cquacmer.dao.IACRecordDao;
import com.cquacmer.dao.IUserDao;
import com.cquacmer.model.ACRecord;
import com.cquacmer.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2015/11/18.
 */
@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {
}
