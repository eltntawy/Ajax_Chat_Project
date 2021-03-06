package com.web.listener; /**
 * Created by eltntawy on 27/03/15.
 */

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class StartHibernateListener implements ServletContextListener {

    private static SessionFactory sessionFactory;

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        com.hibernate.SessionFactory.init(sessionFactory);

    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        if(sessionFactory != null &&!sessionFactory.isClosed())
            sessionFactory.close();
    }
}
