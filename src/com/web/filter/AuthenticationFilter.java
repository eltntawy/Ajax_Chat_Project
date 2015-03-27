package com.web.filter;

import com.hibernate.pojo.User;
import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by eltntawy on 27/03/15.
 */
@WebFilter(filterName = "AuthenticationFilter",urlPatterns = "/chat/*")
public class AuthenticationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpSession session = ((HttpServletRequest) request).getSession(false);

//        if(session != null) {
//            User user = (User) session.getAttribute("user");
//             if(user != null) {
                 chain.doFilter(request, response);
//             } else {
//                 ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath()+"/login.jsp");
//             }
//        } else {
//            ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath()+"/login.jsp");
//        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
