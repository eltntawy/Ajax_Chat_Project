package com.web.servlet;

import com.hibernate.dao.DAOFactory;
import com.hibernate.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by eltntawy on 27/03/15.
 */
@WebServlet(name = "RegisterServlet",urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RegisterServlet doPost");
        HttpSession session = request.getSession();

        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(password);

        boolean isSaved = DAOFactory.getUserDAO().saveNewUser(user);

        if(isSaved) {
            session.setAttribute("user",user);
            response.sendRedirect(request.getContextPath()+"/chat/");
        } else {
            response.sendError(500, "problem while registration user : " + fullName + "\n please contact app admin for more information.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");

        boolean isAvailableEmail = DAOFactory.getUserDAO().isAvailableEmail(email);

        PrintWriter out = response.getWriter();
        if(isAvailableEmail) {
            out.print("This email is available");
        } else {
            out.print("This email not available");
        }

    }
}
