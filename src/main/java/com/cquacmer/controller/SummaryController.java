package com.cquacmer.controller;

import com.cquacmer.model.Summary;
import com.cquacmer.model.User;
import com.cquacmer.service.ISummaryService;
import net.sf.ehcache.search.aggregator.Sum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by xuwei on 15/11/21.
 */

/***
 * 总结相关页面的控制器
 */
@Controller
@RequestMapping("/summary")
public class SummaryController {

    @Resource
    private ISummaryService summaryService;

    /***
     * 查看集训队所有的题解
     * @return
     */
    @RequestMapping("/list")
    public String list(String uid,Model model,HttpSession session){
        int id;
        List<Summary> ret = null;
        if(uid!=null){
            ret=summaryService.getListByUid(Integer.parseInt(uid));
            model.addAttribute("title","集训队总结");
        }else{
            User user=(User)session.getAttribute("user");
            model.addAttribute("title",user.getName()+"的总结");
        }
        model.addAttribute("list",ret);
        return "summary/list";
    }

    /**
     * 添加总结
     * @param summary
     * @return
     */
    @RequestMapping("/add")
    public String add(Summary summary){
        summaryService.add(summary);
        return "summary/list";
    }

    /***
     * 更新总结
     * @param summary
     * @return
     */
    @RequestMapping("/update")
    public String update(Summary summary){
        summaryService.update(summary);
        return "summary/list";
    }

    /***
     * 删除总结
     * @param summary
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Summary summary){
        summaryService.delete(summary);
        return "summary/list";
    }

    /***
     * 根据总结ID查询具体总结页面，并且显示
     * @param s
     * @param model
     * @return
     */
    @RequestMapping("/show")
    public String show(Summary s,Model model){
        Summary summary = summaryService.getById(s.getId());
        model.addAttribute("title",summary.getTitle());
        model.addAttribute("author",summary.getAuthor());
        model.addAttribute("content",summary.getContent());
        model.addAttribute("time",summary.getCreateTime());
        return "article";
    }

}
