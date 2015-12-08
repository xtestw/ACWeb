package com.cquacmer.dao.impl;

import com.cquacmer.dao.IRoleDao;
import com.cquacmer.model.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2015/12/8.
 */
@Repository("roleDao")
public class RoleDao extends BaseDao<Role> implements IRoleDao {
}
