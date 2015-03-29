package com.hibernate.dao;

import com.hibernate.SessionFactory;
import com.hibernate.pojo.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by eltntawy on 27/03/15.
 */
public class UserDAO {

    protected UserDAO() {
    }


    public static boolean saveNewUser(User user) {

        Session session = SessionFactory.getSession();
        Transaction trx = null;

        try {

            trx = session.beginTransaction();

            session.persist(user);


            if (!trx.isActive()) trx.commit();

            return true;
        } catch (HibernateException ex) {
            if (trx != null) trx.rollback();

            ex.printStackTrace();
            return false;
        }
    }

    public static User authenticateUser(User user) {

        Session session = SessionFactory.getSession();
        Transaction trx = null;

        try {
            synchronized (User.class) {
                trx = session.beginTransaction();

                User authenticatedUser = (User) session.createCriteria(User.class).add(Example.create(user)).uniqueResult();

                if (!trx.isActive()) trx.commit();


                return authenticatedUser;
            }

        } catch (HibernateException ex) {
            if (trx != null) trx.rollback();

            ex.printStackTrace();
            return null;
        }

    }


    public static boolean isAvailableEmail(String email) {

        Session session = SessionFactory.getSession();
        Transaction trx = null;
        try {

            synchronized (User.class) {
                trx = session.getTransaction().isParticipating() ? session.getTransaction() : session.beginTransaction();

                List<User> authenticatedUser = session.createCriteria(User.class).add(Restrictions.eq("email", email)).list();


                if (!trx.isActive()) trx.commit();

                return authenticatedUser != null && authenticatedUser.size() == 0;
            }

        } catch (HibernateException ex) {
            if (trx != null) trx.rollback();

            ex.printStackTrace();
            return false;
        }
    }

}
