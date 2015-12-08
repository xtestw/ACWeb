package com.cquacmer.service.impl;

import com.cquacmer.dao.IHustACCodeDao;
import com.cquacmer.model.HustACCode;
import com.cquacmer.service.IHustACCodeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2015/12/8.
 */
@Transactional
@Service("hustACCodeService")
public class HustACCodeService implements IHustACCodeService {
    @Resource
    private IHustACCodeDao hustACCodeDao;
    @Override
    public List<HustACCode> getHustCodesBySourceAndId(String source, String id) {

        List<HustACCode> ret=hustACCodeDao.findList("from HustACCode where source=? and pid = ?",new Object[]{source,id});
        return ret;

    }
}
