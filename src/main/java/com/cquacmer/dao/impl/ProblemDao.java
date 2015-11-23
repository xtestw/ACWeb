package com.cquacmer.dao.impl;

import com.cquacmer.dao.IProblemDao;
import com.cquacmer.model.Problem;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2015/11/22.
 */

@Repository("problemDao")
public class ProblemDao extends BaseDao<Problem> implements IProblemDao {
}
