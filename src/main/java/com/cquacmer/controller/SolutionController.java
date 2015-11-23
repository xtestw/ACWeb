package com.cquacmer.controller;

import com.cquacmer.service.ISolutionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by admin on 2015/11/22.
 */
@Controller
@RequestMapping("/solution")
public class SolutionController {

    @Resource
    private ISolutionService solutionService;
    @RequestMapping("/show")
    public ModelAndView show(String pid){
        if(pid==null) pid="0";
        return new ModelAndView("/solution/show","problem",solutionService.list(pid));
    }
}
