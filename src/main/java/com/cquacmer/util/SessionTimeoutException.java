package com.cquacmer.util;

import org.springframework.core.NestedRuntimeException;

/**
 * Created by admin on 2015/11/18.
 */

public class SessionTimeoutException extends NestedRuntimeException {
    private static final long serialVersionUID = 1L;

    public SessionTimeoutException(String msg) {
        super(msg);
    }

    public SessionTimeoutException(String msg, Throwable obj) {
        super(msg, obj);
    }

}