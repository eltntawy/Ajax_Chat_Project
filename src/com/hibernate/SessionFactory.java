package com.hibernate;

import org.hibernate.Session;

/**
 * Created by eltntawy on 29/03/15.
 */
public class SessionFactory {

    private static Session defaultSession;
    private static Session ajaxSession;
    private static org.hibernate.SessionFactory sessionFactory;

    private SessionFactory() {

    }

    public static void init(org.hibernate.SessionFactory sessionFactory) {
        SessionFactory.defaultSession = sessionFactory.openSession();
        SessionFactory.ajaxSession = sessionFactory.openSession();
    }

    public static Session getSession() {
        if(defaultSession != null && defaultSession.isOpen()) {
            return defaultSession;
        }
        else {
         if(defaultSession != null && !defaultSession.isOpen()) {
             return defaultSession = sessionFactory.openSession();
         }
        }
        return null;
    }

    public static Session getAjaxSession() {
        if(ajaxSession != null && ajaxSession.isOpen()) {
            return ajaxSession;
        }
        else {
            if(ajaxSession != null && !ajaxSession.isOpen()) {
                return ajaxSession = sessionFactory.openSession();
            }
        }
        return null;
    }
}
