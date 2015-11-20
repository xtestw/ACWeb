package com.cquacmer.controller;


import com.cquacmer.model.User;
import com.cquacmer.service.ILoginService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2015/11/20.
 */

@Controller
@RequestMapping("/user")
public class LoginController {
    @Resource
    private ILoginService loginService;
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request,HttpSession httpSession){
        User u=new User();
        u.setEmail((String) request.getParameter("email"));
        u.setPassword((String) request.getParameter("password"));
        String code=(String)request.getParameter("code");
        System.out.println(u.getEmail()+" "+u.getPassword()+" "+code+" "+httpSession.getAttribute("code"));
        User user;
        if(code==null || !code.toLowerCase().equals(httpSession.getAttribute("code").toString().toLowerCase()) || (user=loginService.login(u))==null){
            return new ModelAndView("/login","loginError","登陆失败");
        }else
        {
            httpSession.setAttribute("user",user);
            return new ModelAndView("/user/profile","user",user);
        }
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView register(User u,String code,HttpSession httpSession){
        if(code.isEmpty() || code.toLowerCase().equals(httpSession.getAttribute("code").toString().toLowerCase()) )
        {
            return new ModelAndView("/register","registerError","注册失败");
        }else {
            User user = loginService.register(u);

            return new ModelAndView("/user/profile", "user", loginService.register(u));
        }
    }
}
