package com.cquacmer.service.impl;

import com.cquacmer.dao.INoticeDao;
import com.cquacmer.dao.IUserDao;
import com.cquacmer.model.Notice;
import com.cquacmer.model.User;
import com.cquacmer.service.INoticeService;
import com.cquacmer.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2015/11/18.
 */
@Transactional
@Service("noticeService")
public class NoticeService implements INoticeService {

    @Resource
    private INoticeDao noticeDao;

    @Override
    public List<Notice> listNotices() {
        return noticeDao.findList("from Notice");
    }

    @Override
    public void Add(Notice notice) {
        noticeDao.save(notice);
    }

    @Override
    public void Delete(Notice notice) {
        noticeDao.delete(notice);
    }

    @Override
    public void DeleteById(int id) {
        Notice notice = noticeDao.getById(id);
        if(notice!=null)
            noticeDao.delete(notice);
    }

    @Override
    public Notice QueryById(int id) {
        return noticeDao.getById(id);
    }

    @Override
    public void Update(Notice notice) {
        noticeDao.update(notice);
    }
}
