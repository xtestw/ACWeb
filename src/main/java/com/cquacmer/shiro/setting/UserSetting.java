package com.cquacmer.shiro.setting;

import com.cquacmer.model.User;
import com.cquacmer.service.IUserService;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2015/12/10.
 */
public class UserSetting extends AccessControlFilter {

    @Resource
    private IUserService userService;

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        if (subject == null) {
            return false;
        }
        HttpSession session = ((HttpServletRequest)request).getSession();
        User current_user = (User) session.getAttribute("user");
        //Object recs = session.getAttribute(Constants.USER_MENUS);
        //判断session是否失效，若失效刷新之
        System.out.println("t: "+(current_user==null?"null":current_user.getEmail()));
        if(current_user == null ){
            String email = (String) subject.getPrincipal();
            User user = userService.findByEmail(email);
            session.setAttribute("user", user);

            //session.setAttribute(Constants.USER_MENUS, user.getMenus());
        }
        return true;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return true;
    }

}