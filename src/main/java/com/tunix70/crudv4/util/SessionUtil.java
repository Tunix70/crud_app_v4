package com.tunix70.crudv4.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SessionUtil {
    private Session session;
    private Transaction transaction;

    public Session openSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }

    public Session openTransactionSession(){
        session = openSession();
        transaction = session.beginTransaction();
        return session;
    }
}
