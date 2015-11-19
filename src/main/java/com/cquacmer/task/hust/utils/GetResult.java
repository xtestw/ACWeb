package com.cquacmer.task.hust.utils;

import com.cquacmer.model.Problem;
import com.cquacmer.task.hust.model.Person;
import com.cquacmer.task.hust.model.ProblemPage;
import com.cquacmer.task.hust.model.Solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2015/11/17.
 */
public class GetResult {
    static String names[]={"meixinyu",//(������)52073-2-1-10-1
            "ZWY",//(zzblack)3196-2
            "Glevel",//3235-1
            "Snowdrop",//(����)3372-4-4
            "lajiniunai",//(�ֳ���)3548-6-8
            "yeluorag",//(֣�)31420-1
            "Eighth",//(� �ƽ�)33073-2
            "chenhongwei",//(�º�ΰ)2235-3
            "CST_HYX",//(����)2295-3
            "li924579",//(�����)2473-12-1
            "JamesQi",//2576-2-4
            "misdeer",//(��쿺�)21524-4-2
            "GloriousG",//(����Ң)22807-3
            "liangxianfeng",//(���ȷ�)23158-3-2
            "CHristLu",//(TaoSama)19
            "techay"//(������)};
            };
    public static void main(String[] args){
        List<ProblemPage> Total= HustHelper.GetProblemPages("xtestw");
        List<ProblemPage> cqu= HustHelper.GetProblemPages("cqu_acm");
        System.out.println(Total.size());
        for(ProblemPage p:cqu){
            Total.add(p);
        }        System.out.println(Total.size());

        Map<String,Person> person=new HashMap<String,Person>();
        for(String s:names){
            person.put(s,new Person(s));
        }
        for(String s:names){
            System.out.println(s);
            List<ProblemPage> tmp=HustHelper.GetProblemPages(s);
            for(ProblemPage p:tmp)
                Total.add(p);
            System.out.println(Total.size());

        }
        for(ProblemPage p:Total){
            for(Solution s:p.getSolutions()){
                if(person.containsKey(s.getUsername()))
                    person.get(s.getUsername()).AddProblem(s.getSource()+" "+s.getId());
            }
        }

        for(Person p:person.values()){
            System.out.println(p.ToString());
        }

    }
}
