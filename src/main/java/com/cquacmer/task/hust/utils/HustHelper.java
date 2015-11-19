package com.cquacmer.task.hust.utils;

import com.cquacmer.task.hust.model.ContestItem;
import com.cquacmer.task.hust.model.ProblemPage;
import com.cquacmer.task.hust.model.Solution;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuwei on 15/10/31.
 */
public class HustHelper {

    /**
     *获取到指定用户名所开比赛所有的过题
     *
     * @param username
     *              用户名
     * @return
     *        所有题目的过题情况
     */
    public static List<ProblemPage> GetProblemPages(String username) {
        List<Integer> contestList = GetContestList(username);
        List<ProblemPage> ret = new ArrayList<ProblemPage>();
        for (Integer id : contestList) {
            try {
                Document doc = Jsoup.connect(StaticParams.HUST_OVERVIEW_URL.replace("@cid", id + "")).get();
                for (Element element : doc.select("#viewContest tbody tr")) {
                    Elements td = element.select("td");
                    ProblemPage p = new ProblemPage();
                    String str = td.get(3).select("a").html();
                    if(str.split(" ").length>0) p.setSource(str.split(" ")[0]);
                    if(str.split(" ").length>1) p.setId(str.split(" ")[1]);
                    String url = StaticParams.HUST_STATUS_URL.replace("@cid", id + "");
                    String param = StaticParams.HUST_STATUS_PARAM.replace("@problem", td.get(2).html().split(" ")[1]);
                    String result = HttpHelper.sendPost(url, param);
                    ObjectMapper objectMapper = new ObjectMapper();
                    ContestItem acc = objectMapper.readValue(result, ContestItem.class);
                    ArrayList<Solution> solved = new ArrayList<Solution>();
                    for (Object[] objs : acc.getData()) {
                        Solution solution=new Solution();
                        solution.setId(Integer.parseInt(String.valueOf(objs[0])));
                        solution.setUsername(String.valueOf(objs[1]));
                        solution.setSource(p.getSource());
                        solution.setPid(p.getId());
                        solution.setTime(Integer.parseInt(String.valueOf(objs[5])));
                        solution.setMemsize(Integer.parseInt(String.valueOf(objs[4])));
                        solution.setLanguage(String.valueOf(objs[6]));
                        solution.setCode("");
                        solution.setCodelength(Integer.parseInt(String.valueOf(objs[7])));
                        solution.setSubmit(Long.parseLong(String.valueOf(objs[8])));
                        solved.add(solution);
                    }
                    p.setSolutions(solved);
                    ret.add(p);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ret;
    }


    /**
     * 获取指定用户开的比赛列表
     * @param username
     *          指定用户的用户名
     * @return
     *        指定用户所有的比赛的id
     */
    public static List<Integer> GetContestList(String username) {
        List<Integer> ret = new ArrayList<Integer>();
        try {
            String result = HttpHelper.sendPost(StaticParams.GETLIST_URL_POST,
                    StaticParams.PARAM.replace("xtestw", username));
            ObjectMapper objectMapper = new ObjectMapper();
            ContestItem acc = objectMapper.readValue(result, ContestItem.class);
            for (Object[] p : acc.getData()) {
                ret.add(Integer.parseInt(String.valueOf(p[0])));
            }
        } catch (Exception e) {
        }
        return ret;
    }


    @Test
    public void Test(){
        GetProblemPages("xtestw");
    }
}
