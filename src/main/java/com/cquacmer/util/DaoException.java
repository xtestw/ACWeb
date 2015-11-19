package com.cquacmer.util;

import org.springframework.core.NestedRuntimeException;

/**
 * Created by admin on 2015/11/18.
 */
public class DaoException extends NestedRuntimeException {

    private static final long serialVersionUID = 1L;

    public DaoException(String msg) {
        super(msg);
    }

    public DaoException(String msg, Throwable obj) {
        super(msg, obj);
    }
}
