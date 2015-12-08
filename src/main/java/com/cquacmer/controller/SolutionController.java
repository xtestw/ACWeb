package com.cquacmer.controller;

import com.cquacmer.model.Problem;
import com.cquacmer.model.Solution;
import com.cquacmer.model.User;
import com.cquacmer.service.IProblemService;
import com.cquacmer.service.ISolutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    /***
     * 根据题目ID号查询数据库里所有的题解
     * @param pid
     * @param model
     * @return
     */
    @RequestMapping("/show")
    public String show(String pid,Model model){
        Problem p=problemService.getById(pid);
        model.addAttribute("problem",p);
        List<Solution> solutions=solutionService.list(pid);
        model.addAttribute("list",solutions);
      //  if(pid==null) pid="0";
     //   return new ModelAndView("/solution/show","problem",solutionService.list(pid));
        return "/solution/show";
    }

    /***
     * 根据题目ID号来添加题解，如果题解对应的题目在数据库中还没有，添加
     * @param s
     * @param session
     * @return
     */
    @RequestMapping("/add")
    public ModelAndView add(Solution s,HttpSession session){
        User user=(User)session.getAttribute("user");
        s.getProblem().setTags(s.getProblem().getTags().replace("，",","));
        List<Problem> problemList=problemService.search(s.getProblem().getOjName(),s.getProblem().getOjId(),null);
        String addInfo=null;
        if(problemList.size()>0){
            s.setProblem(problemList.get(0));
        }else{
            problemService.add(s.getProblem());
        }
        s.setSubmit((new Date()));
        if(user!=null) s.setUsername(user.getUsername());
        solutionService.add(s);
        addInfo="添加成功！";
        return new ModelAndView("/solution/add","addInfo",addInfo);
    }

    /**
     * 显示具体的题解
     * @param solution
     * @param model
     * @return
     */
    @RequestMapping("/showById")
    public String show(Solution solution,Model model){
        Solution s=solutionService.getById(solution.getId());
        model.addAttribute("title",s.getProblem().getOjName()+" "+s.getProblem().getOjId()+"的");
        model.addAttribute("author",s.getUsername());
        model.addAttribute("content",s.getSolution());
        model.addAttribute("time", s.getSolution());
        return "article";
    }

}
