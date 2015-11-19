package com.cquacmer.task.hust.model;

/**
 * Created by xuwei on 15/11/1.
 */
public class Solution {
    private int id;
    private String source;
    private String pid;
    private String username;
    private String language;
    private String code;
    private int memsize;
    private int time;
    private long submit;
    private int codelength;

    public int getCodelength() {
        return codelength;
    }

    public void setCodelength(int codelength) {
        this.codelength = codelength;
    }

    public long getSubmit() {
        return submit;
    }

    public void setSubmit(long submit) {
        this.submit = submit;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMemsize() {
        return memsize;
    }

    public void setMemsize(int memsize) {
        this.memsize = memsize;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", pid='" + pid + '\'' +
                ", username='" + username + '\'' +
                ", language='" + language + '\'' +
                ", code='" + code + '\'' +
                ", memsize=" + memsize +
                ", time=" + time +
                '}';
    }
}
