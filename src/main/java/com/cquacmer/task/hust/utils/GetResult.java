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
    static String names[]={"meixinyu",//(Õ€Õ€Õ€)52073-2-1-10-1
            "ZWY",//(zzblack)3196-2
            "Glevel",//3235-1
            "Snowdrop",//(œÚ∏ª¡ÿ)3372-4-4
            "lajiniunai",//(¡÷≥€”Ó)3548-6-8
            "yeluorag",//(÷£Ó£Ω‹)31420-1
            "Eighth",//(¿Ó∫£ ª∆Ω°)33073-2
            "chenhongwei",//(≥¬∫ÏŒ∞)2235-3
            "CST_HYX",//(…Ò÷€)2295-3
            "li924579",//(Œ‚∂˚¡¢)2473-12-1
            "JamesQi",//2576-2-4
            "misdeer",//(¡÷Ïø∫Ë)21524-4-2
            "GloriousG",//(π˘◊”“¢)22807-3
            "liangxianfeng",//(¡∫œ»∑Ê)23158-3-2
            "CHristLu",//(TaoSama)19
            "techay"//(Õı≥Ω≥Ω)};
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
