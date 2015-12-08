package com.cquacmer.service;

import com.cquacmer.model.Pagination;
import com.cquacmer.model.Problem;

import java.util.List;

/**
 * Created by admin on 2015/11/22.
 */
public interface IProblemService {
    public void add(Problem problem);
    public List<Problem> list();
    public List<Problem> search(String ojName,String ojId,String tags);
    public Pagination<Problem> list(int index,int pageSize);
    public Pagination<Problem> search(String ojName,String ojId,String tags,int index,int PageSize);
    public void update(Problem p);
    public Problem getById(String Pid);
    public Problem getBySourceAndPid(String source,String id);
}
