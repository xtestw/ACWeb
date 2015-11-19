package com.cquacmer.task.count.hust;

import com.cquacmer.dao.IACRecordDao;
import com.cquacmer.dao.IUserDao;
import com.cquacmer.model.ACRecord;
import com.cquacmer.model.User;
import com.cquacmer.task.count.BaseOpreation;
import com.cquacmer.task.hust.model.ContestItem;
import com.cquacmer.task.hust.utils.HttpHelper;
import com.cquacmer.task.hust.utils.StaticParams;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2015/11/18.
 */
@Service("Hust")
public class HUST extends BaseOpreation implements Runnable {

    public static String HUST_STATUS_URL="http://acm.hust.edu.cn/vjudge/problem/fetchStatus.action";
    public static String HUST_STATUS_PARAM="draw=1&start=0&length=1000&search[value]=&search[regex]=false&un=@username&OJId=All&probNum=&res=1&language=&orderBy=run_id";


    public void ReadAccount() {
        List<User> users=userDao.findList("from User a");
        for(User user:users){
            accounts.add(user.getHust_name());
        }
    }

    public void Query() {
        for(String str:accounts){
            try {
                String result= HttpHelper.sendPost(HUST_STATUS_URL,HUST_STATUS_PARAM.replace("@username",str));
                ObjectMapper objectMapper = new ObjectMapper();
                System.out.println(result);
                ContestItem acc = objectMapper.readValue(result, ContestItem.class);
                for (Object[] p : acc.getData()) {
                    ACRecord record=new ACRecord();
                    record.setPid(String.valueOf(p[12]));
                    record.setSource(String.valueOf(p[11]));
                    record.setUsername(str);
                    records.add(record);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }



    public void run() {
        ReadAccount();
        Query();
        InsertOrUpdateDatabase();
    }


    public class Item{
        private ArrayList<Object[]> data;
        private String draw;
        private int recordsFiltered;
        private int recordsTotal;

        public ArrayList<Object[]> getData() {
            return data;
        }

        public void setData(ArrayList<Object[]> data) {
            this.data = data;
        }

        public String getDraw() {
            return draw;
        }

        public void setDraw(String draw) {
            this.draw = draw;
        }

        public int getRecordsFiltered() {
            return recordsFiltered;
        }

        public void setRecordsFiltered(int recordsFiltered) {
            this.recordsFiltered = recordsFiltered;
        }

        public int getRecordsTotal() {
            return recordsTotal;
        }

        public void setRecordsTotal(int recordsTotal) {
            this.recordsTotal = recordsTotal;
        }

        @Override
        public String toString() {
            return "ContestItem{" +
                    "data=" + data +
                    ", draw='" + draw + '\'' +
                    ", recordsFiltered=" + recordsFiltered +
                    ", recordsTotal=" + recordsTotal +
                    '}';
        }
    }
}
