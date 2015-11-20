package com.cquacmer.controller;

import com.cquacmer.model.User;
import com.cquacmer.service.IUserService;
import com.cquacmer.task.count.hust.HUST;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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
}