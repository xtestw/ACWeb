package com.cquacmer.task.count.hdu;

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
public class HDU extends BaseOpreation implements Runnable {
    public static String HDU_STATUS_URL="http://acm.hdu.edu.cn/userstatus.php?user=@username";
    @Override
    public void ReadAccount() {
        List<User> users=userDao.findList("from User a");
        for(User u:users){
            accounts.add(u.getHdu());
        }
    }

    @Override
    public void Query() {
        for(String str:accounts){
            try {
                Document doc = Jsoup.connect(HDU_STATUS_URL.replace("@username", str)).get();
                if(doc.select("p script").first()==null) continue;
                for(String element:doc.select("p script").first().html().split(";")){
                    System.out.println(element);
                            String id=element.split(",")[0].replace("p(","");
                    System.out.println(id);
                            ACRecord record=new ACRecord();
                            record.setUsername(str);
                            record.setSource("HDU");
                            record.setPid(id + "");
                            records.add(record);
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
