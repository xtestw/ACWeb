package com.cquacmer.dao.impl;

import com.cquacmer.dao.IACRecordDao;
import com.cquacmer.model.ACRecord;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2015/11/18.
 */
@Repository("aCRecordDao")
public class ACRecordDao extends BaseDao<ACRecord> implements IACRecordDao {
}
