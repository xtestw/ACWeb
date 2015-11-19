package com.cquacmer.task.hust.utils;

/**
 * Created by xuwei on 15/10/31.
 */
public class StaticParams {
    public static String PARAM="draw=1&order[0][column]=0&order[0][dir]=asc&start=0&length=2000&search[value]=&search[regex]=false&contestType=0&contestRunningStatus=0&contestOpenness=1&title=&manager=xtestw" ;
    public static String GETLIST_URL_POST="http://acm.hust.edu.cn/vjudge/contest/listContest.action";
    public static String HUST_HOST="http://acm.hdu.edu.cn";
    public static String HUST_OVERVIEW_URL="http://acm.hust.edu.cn/vjudge/contest/view.action?cid=@cid#overview";
    public static String HUST_STATUS_URL="http://acm.hust.edu.cn/vjudge/contest/fetchStatus.action?cid=@cid";
    public static String HUST_STATUS_PARAM="draw=1&start=0&length=1000&search[value]=&search[regex]=false&un=&num=@problem&res=1&lang=";
}
