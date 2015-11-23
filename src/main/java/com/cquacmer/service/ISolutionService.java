package com.cquacmer.service;

import com.cquacmer.model.Pagination;
import com.cquacmer.model.Problem;
import com.cquacmer.model.Solution;

import java.util.List;

/**
 * Created by admin on 2015/11/22.
 */
public interface ISolutionService {

    public Problem list(String pid);
}
