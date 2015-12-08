package com.cquacmer.dao.impl;

import com.cquacmer.dao.IPermissionDao;
import com.cquacmer.model.Permission;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2015/12/8.
 */
@Repository("permissionDao")
public class PermissionDao extends BaseDao<Permission> implements IPermissionDao  {
}
