package com.cquacmer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xuwei on 15/11/21.
 */
@Controller
@RequestMapping("/summary")
public class SummaryController {

    @RequestMapping("/list")
    public ModelAndView list(){
        return new ModelAndView("");
    }
}
