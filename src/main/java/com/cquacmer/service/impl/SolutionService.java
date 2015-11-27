package com.cquacmer.service.impl;

import com.cquacmer.dao.IProblemDao;
import com.cquacmer.dao.ISolutionDao;
import com.cquacmer.model.Problem;
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
    @Resource
    private IProblemDao problemDao;
    @Override
    public Problem list(String pid) {
        Problem p=problemDao.get("from Problem where id=?",Integer.parseInt(pid));
        p.getSolutions();
       // List<Solution> ret=solutionDao.findList("from ")
        return p;
    }

    @Override
    public Solution add(Solution solution) {
        solutionDao.save(solution);
        return solution;
    }
}
