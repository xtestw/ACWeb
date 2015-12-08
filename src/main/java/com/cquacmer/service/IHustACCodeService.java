package com.cquacmer.service;

import com.cquacmer.model.HustACCode;

import java.util.List;

/**
 * Created by admin on 2015/12/8.
 */
public interface IHustACCodeService {
    public List<HustACCode> getHustCodesBySourceAndId(String source,String id);
}
