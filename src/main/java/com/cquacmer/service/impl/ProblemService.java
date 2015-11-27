package com.cquacmer.service.impl;

import com.cquacmer.dao.IProblemDao;
import com.cquacmer.model.Pagination;
import com.cquacmer.model.Problem;
import com.cquacmer.service.IProblemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2015/11/22.
 */
@Transactional
@Service("problemService")
public class ProblemService implements IProblemService {

    @Resource
    private IProblemDao problemDao;

    @Override
    public List<Problem> list() {
        return problemDao.findList("from Problem");
    }

    @Override
    public List<Problem> search(String ojName, String ojId, String tags) {
        String hql="from Problem where ";
        List<Object> params=new ArrayList<Object>();
       boolean f=false;
        if(ojName!=null) {
            params.add(ojName);
            if(f) hql=hql+"and ";hql=hql+"ojName =?";
            f=true;
        }
        if(ojId!=null) {
            params.add(ojId);
            if(f) hql=hql+" and ";hql=hql+"ojId =?";
            f=true;
        }
        if(tags!=null) {
            params.add(tags);
            if(f) hql=hql+" and ";hql=hql+"tags like ?";
            f=true;
        }
        List<Problem> ret=problemDao.findList(hql,params.toArray());
        return ret==null?(new ArrayList<Problem>()):ret;
    }

    @Override
    public Pagination<Problem> list(int index, int pageSize) {
        return problemDao.findPagination("from Problem",index,pageSize);
    }

    @Override
    public Pagination<Problem> search(String ojName, String ojId, String tags, int index, int pageSize) {

        String hql="from Problem where ";
        List<Object> params=new ArrayList<Object>();
        boolean f=false;
        if(ojName!=null) {
            params.add(ojName);
            if(f) hql=hql+"and ";hql=hql+"ojName =?";
            f=true;
        }
        if(ojId!=null) {
            params.add(ojId);
            if(f) hql=hql+" and ";hql=hql+"ojId =?";
            f=true;
        }
        if(tags!=null) {
            params.add(tags);
            if(f) hql=hql+" and ";hql=hql+"tags like ?";
            f=true;
        }
        Pagination<Problem> ret=problemDao.findPagination(hql,index,pageSize, params.toArray());
        return ret;
    }

    @Override
    public void update(Problem p) {
        problemDao.update(p);
    }
}
