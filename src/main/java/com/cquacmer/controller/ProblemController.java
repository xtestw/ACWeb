package com.cquacmer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Objects;

/**
 * Created by admin on 2015/11/4.
 */
@Controller
@RequestMapping("/problem")
public class ProblemController {

    @RequestMapping("/add")
    public String add(Map<String,Object> map){

        return "list";
    }
}
