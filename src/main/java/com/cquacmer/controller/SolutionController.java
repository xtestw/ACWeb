package com.cquacmer.controller;

import com.cquacmer.model.Problem;
import com.cquacmer.model.Solution;
import com.cquacmer.model.User;
import com.cquacmer.service.IProblemService;
import com.cquacmer.service.ISolutionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2015/11/22.
 */
@Controller
@RequestMapping("/solution")
public class SolutionController {

    @Resource
    private ISolutionService solutionService;
    @Resource
    private IProblemService problemService;
    @RequestMapping("/show")
    public ModelAndView show(String pid){
        if(pid==null) pid="0";
        return new ModelAndView("/solution/show","problem",solutionService.list(pid));
    }
    @RequestMapping("/add")
    public ModelAndView add(String ojName,String ojId,String solution,HttpSession session){
        User user=(User)session.getAttribute("user");
        List<Problem> problemList=problemService.search(ojName,ojId,null);
        Solution s=new Solution();
        if(problemList.size()>0){
            s.setProblem(problemList.get(0));
            s.setSolution(solution);
            s.setSubmit((new Date()));
            s.setUsername(user.getUsername());
            solutionService.add(s);
        }

        return new ModelAndView("/solution/add");
    }
}
