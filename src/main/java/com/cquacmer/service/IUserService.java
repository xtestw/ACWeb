package com.cquacmer.service;

import com.cquacmer.model.User;

import java.util.List;

/**
 * Created by admin on 2015/11/18.
 */
public interface IUserService {
    public List<User> listUsers();
    public void update(User u);
}
