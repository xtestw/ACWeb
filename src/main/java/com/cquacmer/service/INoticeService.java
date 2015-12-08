package com.cquacmer.service;

import com.cquacmer.model.Notice;
import com.cquacmer.model.User;
import net.sf.ehcache.search.expression.Not;

import java.util.List;

/**
 * Created by admin on 2015/11/18.
 */
public interface INoticeService {
    public List<Notice> listNotices();
    public void Add(Notice notice);
    public void Delete(Notice notice);
    public void DeleteById(int id);
    public Notice QueryById(int id);
    public void Update(Notice notice);
}
