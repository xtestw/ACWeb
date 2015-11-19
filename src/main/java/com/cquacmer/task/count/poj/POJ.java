package com.cquacmer.task.count.poj;

import com.cquacmer.model.ACRecord;
import com.cquacmer.model.User;
import com.cquacmer.task.count.BaseOpreation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2015/11/18.
 */
public class POJ extends BaseOpreation implements Runnable{

    public static  String POJ_STATUS_URL="http://poj.org/userstatus?user_id=@username";
    @Override
    public void ReadAccount() {

        List<User> users=userDao.findList("from User a");
        for(User u :users){
            accounts.add(u.getPoj());
        }
    }

    @Override
    public void Query() {
        for(String str:accounts){
            try {
                Document document= Jsoup.connect(POJ_STATUS_URL.replace("@username",str)).get();
                String s=document.body().select("script").first().html();
                if(s.split("}").length==2){
                    for(String st:s.split("}")[1].replace("\n","").replace(")",",").split(",")){
                            System.out.println(st);
                        if(st.length()!=6) continue;
                        ACRecord record=new ACRecord();
                        record.setSource("POJ");
                        record.setPid(st.replace("p(",""));
                        record.setUsername(str);
                        records.add(record);
                    }
                }
            } catch (IOException e) {
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
