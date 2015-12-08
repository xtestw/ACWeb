package com.cquacmer.service.impl;

import com.cquacmer.dao.ISummaryDao;
import com.cquacmer.dao.impl.SummaryDao;
import com.cquacmer.model.Summary;
import com.cquacmer.service.ISummaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2015/12/8.
 */
@Transactional
@Service("summaryService")
public class SummaryService implements ISummaryService {
    @Resource
    private ISummaryDao summaryDao;
    @Override
    public void add(Summary summary) {
        summaryDao.save(summary);
    }

    @Override
    public void update(Summary summary) {
        summaryDao.update(summary);
    }

    @Override
    public void delete(Summary summary) {
        summaryDao.delete(summary);
    }

    @Override
    public void deleteById(int id) {
        Summary summary=summaryDao.getById(id);
        if(summary!=null)
            summaryDao.delete(summary);
    }

    @Override
    public Summary getById(int id) {
        return summaryDao.getById(id);
    }

    @Override
    public List<Summary> getListByUid(int uid) {
        return summaryDao.findList("from Summary u where u.author.id = ?",uid);
    }

    @Override
    public List<Summary> getListByUsername(String name) {
        return summaryDao.findList("from Summary u where u.author.name = ?",name);
    }

    @Override
    public List<Summary> getList() {
        return summaryDao.findList("from Summary");
    }
}
