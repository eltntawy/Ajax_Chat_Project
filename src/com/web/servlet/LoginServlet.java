package com.web.servlet;

import com.hibernate.dao.DAOFactory;
import com.hibernate.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by eltntawy on 27/03/15.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Login Servlet doPost");
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        if(email != null && password != null) {
            User user = new User(email,password);

            user = DAOFactory.getUserDAO().authenticateUser(user);

            if(user != null) {
                request.getSession().setAttribute("user",user);
                response.sendRedirect(request.getContextPath()+"/chat/index.jsp");
            } else {
                response.sendError(404,"user not found please register first");
            }

        } else {
            response.sendError(404,"User name not found please register first !!");
        }

    }
}
