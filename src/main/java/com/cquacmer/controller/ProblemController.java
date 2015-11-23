package com.cquacmer.controller;

import com.cquacmer.service.IProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * Created by admin on 2015/11/4.
 */
@Controller
@RequestMapping("/problem")
public class ProblemController {


    @Resource
    private IProblemService problemService;

    @RequestMapping("/add")
    public String add(Map<String,Object> map){

        return "list";
    }

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request){
        String index=request.getParameter("page");
        String pageSize=request.getParameter("pageSize");
        if(index==null) index="1";
        if (pageSize==null) pageSize="20";

        return new ModelAndView("/problem/list","problems",problemService.list(Integer.parseInt(index),Integer.parseInt(pageSize)));
    }

    @RequestMapping("/search")
    public ModelAndView search(HttpServletRequest request){
        String source=request.getParameter("ojName");
        String pid=request.getParameter("ojId");
        String tags=request.getParameter("tag");
        String index=request.getParameter("page");
        String pageSize=request.getParameter("pageSize");
        if(index==null) index="1"; if(pageSize==null) pageSize="20";
        return new ModelAndView("/problem/list","problems",problemService.search(source, pid, tags,Integer.parseInt(index),Integer.parseInt(pageSize)));
    }
}
