package com.cquacmer.dao.impl;

import com.cquacmer.dao.ISolutionDao;
import com.cquacmer.model.Solution;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2015/11/22.
 */


@Repository("solutionDao")
public class SolutionDao extends BaseDao<Solution> implements ISolutionDao {
}
