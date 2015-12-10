package com.cquacmer.controller;

import com.cquacmer.model.User;
import com.cquacmer.service.IUserService;
import com.cquacmer.task.count.hust.HUST;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2015/11/18.
 */
@Controller
@RequestMapping("/user")
public class UserController{
    @Resource
    private IUserService userService;
    @Resource(name="Hust")
    private HUST hust;
    @ResponseBody
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public ModelAndView list(){
        return new ModelAndView("/user/list","listReuslt",userService.listUsers());
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ModelAndView update(User u)
    {
        userService.update(u);
        return new ModelAndView("profile");
    }

    @RequestMapping(value = "profile")
    public String profile(HttpSession session,Model model){
        Subject subject= SecurityUtils.getSubject();
        if(subject.isAuthenticated()){

            User user=userService.findByEmail( (String)subject.getPrincipal());
            if(session.getAttribute("user")==null)
                 session.setAttribute("user", user);
            model.addAttribute("user",user);
            return "/user/profile";
        }else{
            return "/login";
        }
    }
}