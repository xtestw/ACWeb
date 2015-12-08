package com.cquacmer.controller;

import com.cquacmer.model.Notice;
import com.cquacmer.service.INoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by xuwei on 15/11/21.
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    private INoticeService noticeService;

    @RequestMapping("/list")
    public ModelAndView list(){
        return new ModelAndView("");
    }

    public ModelAndView add(Notice notice){
        return new ModelAndView("");
    }

    public ModelAndView delete(Notice notice){
        return new ModelAndView("");
    }
}
