package com.cquacmer.task.hust.model;

import java.util.ArrayList;

/**
 * Created by xuwei on 15/11/1.
 */
public class ProblemPage {
    private String url;
    private String source;
    private String id;
    private ArrayList<Solution> solutions;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(ArrayList<Solution> solutions) {
        this.solutions = solutions;
    }
}
