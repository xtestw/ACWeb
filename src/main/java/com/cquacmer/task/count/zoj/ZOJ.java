package com.cquacmer.task.count.zoj;

import com.cquacmer.model.ACRecord;
import com.cquacmer.model.User;
import com.cquacmer.task.count.BaseOpreation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2015/11/18.
 */
public class ZOJ extends BaseOpreation implements Runnable {
    public static String ZOJ_STATUS_URL="http://acm.zju.edu.cn/onlinejudge/showRuns.do?contestId=1&search=true&firstId=-1&lastId=@lastid&problemCode=&handle=@username&idStart=&idEnd=&judgeReplyIds=5";

    @Override
    public void ReadAccount() {
        List<User> users=userDao.findList("from User a");
        for(User u:users){
            accounts.add(u.getZoj());
        }
    }

    @Override
    public void Query() {
        int lastId=-1;
        for(String str:accounts){
            int cnt=0;
            System.out.println(str);
            while(true) {
                try {
                    Document doc = Jsoup.connect(ZOJ_STATUS_URL.replace("@lastid",lastId+"").replace("@username",str)).get();
                    int flag=1;
                    for(Element t:doc.body().select(".list tbody tr")){
                        if(t.attr("class").equals("rowHeader")) continue;
                        ACRecord record=new ACRecord();
                        record.setPid(t.select("td a").first().html());
                        record.setSource("ZOJ");
                        record.setUsername(str);
                        if(lastId==-1 || lastId> Integer.parseInt(t.select("td").first().html())) {
                            lastId=Integer.parseInt(t.select("td").first().html());
                        }
                        flag=0;
                        System.out.println(t.select("td a").first().html());
                    }
                    if(flag==1) break;
                } catch (IOException e) {
                    e.printStackTrace();
                    cnt++;if(cnt>5) break;
                }

            }
        }
    }

    @Override
    public void run() {
        ReadAccount();
        Query();
        InsertOrUpdateDatabase();
    }
}
