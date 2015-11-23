package com.cquacmer.service.impl;

import com.cquacmer.dao.ISolutionDao;
import com.cquacmer.model.Solution;
import com.cquacmer.service.ISolutionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2015/11/22.
 */
@Transactional
@Service("solutionService")
public class SolutionService implements ISolutionService {
    @Resource
    private ISolutionDao solutionDao;
    @Override
    public List<Solution> list(String pid) {
        return solutionDao.findList("from Solution s where s.pid=?",Integer.parseInt(pid));
    }
}
