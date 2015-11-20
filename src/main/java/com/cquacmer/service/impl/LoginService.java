package com.cquacmer.service.impl;

import com.cquacmer.dao.IUserDao;
import com.cquacmer.model.User;
import com.cquacmer.service.ILoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by admin on 2015/11/20.
 */

@Transactional
@Service("loginService")
public class LoginService implements ILoginService {
    private  User user;
    @Resource
    private IUserDao userDao;
    @Override
    public boolean isExist(String email) {
        if(userDao.findByProperty("email",email).size()==0)
            return false;
        return true;
    }

    @Override
    public boolean checkPassword(User u) {
        user=userDao.get("from User u where u.email=? and u.password=?",u.getEmail(),u.getPassword());
        if(user!=null) return true;
        return false;
    }

    @Override
    public User register(User u) {
        if(isExist(u.getUsername())) return null ;
        userDao.save(u);
        return  u;
    }

    @Override
    public User login(User u) {

        if(checkPassword(u)){
            return user;
        }
        return null;
    }
}
