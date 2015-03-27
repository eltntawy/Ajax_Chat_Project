package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eltntawy on 19/03/15.
 */
@WebServlet(name = "ValidateServlet",urlPatterns = "/ValidateServlet")
public class ValidateServlet extends HttpServlet {

    List<String> listName = new ArrayList<String>();

    @Override
    public void init() throws ServletException {
        listName.add("mohamed");
        listName.add("Ahmed");
        listName.add("eman");
        listName.add("heba");
        listName.add("ismael");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("APPLICATION/JSON");
        String name = request.getParameter("username");

        if(name != null) {
            if(listName.contains(name)) {
                response.getWriter().print("{\"error\":\"valid username :)\"}");
            } else {
                response.getWriter().print("{\"error\":\"invalid username :(\"}");
            }
        } else {
            response.getWriter().print("{\"error\":\"invalid username :(\"}");
        }

    }
}
