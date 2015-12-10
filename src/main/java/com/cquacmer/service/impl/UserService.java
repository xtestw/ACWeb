package com.cquacmer.service.impl;

import com.cquacmer.dao.IRoleDao;
import com.cquacmer.dao.IUserDao;
import com.cquacmer.model.Permission;
import com.cquacmer.model.Role;
import com.cquacmer.model.User;
import com.cquacmer.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by admin on 2015/11/18.
 */
@Transactional
@Service("userService")
public class UserService implements IUserService {

    @Resource
    private IUserDao userDao;
    @Resource
    private IRoleDao roleDao;
    @Override
    public List<User> listUsers() {
        return userDao.findList("from User");
    }

    @Override
    public void update(User u) {
        userDao.update(u);
    }

    @Override
    public void delete(User u) {
        userDao.delete(u);
    }

    @Override
    public void add(User u) {
        userDao.save(u);
    }

    @Override
    public Set<String> findRoles(String email) {
        User u=findByEmail(email);
       List<Role> roles= u.getRole();
        Set<String> s=new HashSet<String>();
        for(Role role: roles){
            s.add(role.getRole());
        }
        return s;
    }

    @Override
    public Set<String> findPermissions(String email) {
        User u=findByEmail(email);
        List<Role> roles= u.getRole();
        Set<String> ret=new HashSet<String>();
        for(Role role:roles){
            for(Permission p:role.getPermissions())
            {
                ret.add(p.getPermission());
            }
        }
        return ret;
    }

    @Override
    public User findByEmail(String email) {
        return userDao.get("from User u where u.email = ?",email);
    }
}
