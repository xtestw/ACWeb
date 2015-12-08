package com.cquacmer.dao.impl;

import com.cquacmer.dao.ISummaryDao;
import com.cquacmer.model.Summary;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2015/12/8.
 */

@Repository("summaryDao")
public class SummaryDao extends BaseDao<Summary> implements ISummaryDao {
}
