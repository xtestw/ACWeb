package com.cquacmer.util;

import org.hibernate.Session;

import java.io.Serializable;

/**
 * Created by admin on 2015/11/18.
 */
public abstract interface HibernateHandler extends Serializable {
    public abstract Object doInHibernate(Session paramSession);
}
