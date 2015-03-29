package com.hibernate.dao;

import org.hibernate.SessionFactory;

/**
 * Created by eltntawy on 27/03/15.
 */
public class DAOFactory {

    private static SessionFactory  sessionFactory;

    private static UserDAO userDAO;
    private static MessageDAO messageDAO;

    public static void init(SessionFactory sessionFactory) {
        DAOFactory.sessionFactory = sessionFactory;
        DAOFactory.userDAO = new UserDAO();
        DAOFactory.messageDAO = new MessageDAO();
    }

    private DAOFactory () {}

    public static UserDAO getUserDAO () {
        return userDAO;
    }

    public static MessageDAO getMessageDAO () {
        return messageDAO;
    }
}
