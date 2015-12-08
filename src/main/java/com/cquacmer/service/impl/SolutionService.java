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

    /***
     * 根据Problem的Id获取其对应的所有的题解
     * @param pid
     *          Problem的Id
     * @return
     *          对应的所有的题解
     */
    @Override
    public List<Solution> list(String pid) {
        int id=Integer.parseInt(pid);
        List<Solution> ret=solutionDao.findList("from Solution where pid= ?",id);
        return ret;
    }

    /***
     * 增加新的题解
     * @param solution
     * @return
     */
    @Override
    public Solution add(Solution solution) {
        solutionDao.save(solution);
        return solution;
    }

    /**
     * 更新题解
     * @param solution
     * @return
     */
    @Override
    public Solution Update(Solution solution) {
        solutionDao.update(solution);
        return solution;
    }

    /**
     * 根据ID查询ID
     * @param id
     * @return
     */
    @Override
    public Solution getById(int id) {
        return solutionDao.getById(id);
    }


}
