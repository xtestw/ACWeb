package com.cquacmer.service;

import com.cquacmer.model.User;

/**
 * Created by admin on 2015/11/20.
 */
public interface ILoginService {
    public boolean isExist(String username);
    public boolean checkPassword(User u);
    public User register(User u);
    public User login(User u);
}
