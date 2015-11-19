package com.cquacmer.service.impl;

import com.cquacmer.dao.IUserDao;
import com.cquacmer.model.User;
import com.cquacmer.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2015/11/18.
 */
@Transactional
@Service("userService")
public class UserService implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public List<User> listUsers() {
        return userDao.findList("from User");
    }
}
