package com.cquacmer.dao.impl;

import com.cquacmer.dao.INoticeDao;
import com.cquacmer.dao.IUserDao;
import com.cquacmer.model.Notice;
import com.cquacmer.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2015/11/18.
 */
@Repository("noticeDao")
public class NoticeDao extends BaseDao<Notice> implements INoticeDao {
}
