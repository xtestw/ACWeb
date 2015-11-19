package com.cquacmer.controller;

import com.cquacmer.dao.INoticeDao;
import com.cquacmer.service.INoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by admin on 2015/11/20.
 */

@Controller
@RequestMapping("/")
public class HomeController {
    @Resource
    private INoticeService noticeService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView home(){
        System.out.println("home");
        return new ModelAndView("/index","notices",noticeService.listNotices());
    }
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public ModelAndView index(){
        System.out.println("index");
        return new ModelAndView("/index","notices",noticeService.listNotices());
    }
}
