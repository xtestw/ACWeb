package com.cquacmer.task.count.fzu;

import com.cquacmer.model.ACRecord;
import com.cquacmer.model.User;
import com.cquacmer.task.count.BaseOpreation;
import com.cquacmer.task.hust.utils.HttpHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2015/11/18.
 */
public class FZU extends BaseOpreation implements Runnable {
    public static String FZU_STATUS_URL="http://acm.fzu.edu.cn/compare.php?act=1";
    public static String FZU_STATUS_PARAM="uname1=@username&uname2=&cmp=Compare";
    @Override
    public void ReadAccount() {
        List<User> users=userDao.findList("from User a");
        for(User u:users){
            accounts.add(u.getFzu());
        }
    }

    @Override
    public void Query() {
        for(String str:accounts){
            //Document p =new Document( HttpHelper.sendPost(FZU_STATUS_URL,FZU_STATUS_PARAM.replace("@username", str)));
            try {
                Document p=Jsoup.connect(FZU_STATUS_URL).data("uname1",str)
                        .data("uname2", "")
                        .data("cmp", "Compare").post();
                for(Element i:p.select("td a")){
                    ACRecord record=new ACRecord();
                    record.setUsername(str);
                    record.setSource("FZU");
                    record.setPid(i.html());
                    records.add(record);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //       System.out.println(p.toString());

        }
    }

    @Override
    public void run() {
        ReadAccount();
        Query();
        InsertOrUpdateDatabase();

    }
}
