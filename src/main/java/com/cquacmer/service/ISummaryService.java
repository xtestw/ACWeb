package com.cquacmer.service;

import com.cquacmer.model.Summary;
import net.sf.ehcache.search.aggregator.Sum;

import java.util.List;

/**
 * Created by admin on 2015/12/8.
 */
public interface ISummaryService {
    public void add(Summary summary);
    public void update(Summary summary);
    public void delete(Summary summary);
    public void deleteById(int id);
    public Summary getById(int id);
    public List<Summary> getListByUid(int uid);
    public List<Summary> getListByUsername(String name);
    public List<Summary> getList();
}
