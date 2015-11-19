package com.cquacmer.task.count.codeforces;

import com.cquacmer.model.ACRecord;
import com.cquacmer.model.User;
import com.cquacmer.task.count.BaseOpreation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by admin on 2015/11/19.
 */
public class CODEFORCES extends BaseOpreation implements Runnable {
    public static String CODEFORCES_STATUS_URL="http://codeforces.com/submissions/@username/page/@page";
    @Override
    public void ReadAccount() {
        List<User> users=userDao.findList("from User a");
        for(User u:users){
            accounts.add(u.getCodeforces());
        }
    }

    @Override
    public void Query() {
        for(String str:accounts){
            try {
                Document doc = Jsoup.connect(CODEFORCES_STATUS_URL.replace("@username", str).replace("@page", "1")).get();
                int TotPage=0;
                if(doc.select(".page-index a").last()!=null)
                    TotPage=Integer.parseInt(doc.select(".page-index a").last().html());
                System.out.println("total"+TotPage);
                if(TotPage>60) TotPage=0;
                for(int i=0;i<TotPage;i++){
                    Document document = Jsoup.connect(CODEFORCES_STATUS_URL.replace("@username", str).replace("@page", ""+i)).get();

                    for(Element element:document.select(".status-frame-datatable tbody tr")){
                        if(element.attr("class").equals("first-row")) continue;
                        if(!element.select("td .verdict-accepted").html().equals("Accepted")) continue;
                        ACRecord record=new ACRecord();
                        record.setPid("");
                        for(Element p:element.select("td a")){
                            System.out.println(p.html());
                            if(p.attr("href").contains("/profile/")) {
                                record.setUsername(p.html());
                            }
                            if(p.attr("href").contains("problemset/problem"))
                                record.setPid(p.html().split(" ")[0]);

                        }
                        if(record.getUsername().equals(str) && !record.getPid().isEmpty()){
                            record.setSource("CodeForces");
                            records.add(record);
                        }
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
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
