package com.cquacmer.task.hust.model;

import java.util.HashSet;

/**
 * Created by admin on 2015/11/18.
 */
public class Person {
    public String name;
    public HashSet<String> problems;
    public Person(String str){
        name=str;
        problems=new HashSet<String>();
    }
    public void  AddProblem(String str){
        problems.add(str);
    }

    public int Total(){
        return problems.size();
    }

    public String ToString(){
        return "<tr><td>"+name+"</td><td> "+problems.size()+"</td></tr>";
    }
}
