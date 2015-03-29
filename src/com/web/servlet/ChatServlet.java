package com.web.servlet;



import com.hibernate.pojo.User;
import com.hibernate.dao.DAOFactory;
import com.hibernate.pojo.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by eltntawy on 22/03/15.
 */
@WebServlet(name = "ChatServlet", urlPatterns = "/chat/ChatServlet")
public class ChatServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ChatServlet : Ajax Send Message");
        String username = request.getParameter("username");
        String msgStr = request.getParameter("message");

        User user = (User) request.getSession().getAttribute("user");

        if(user != null && msgStr != null && msgStr.split(" ").length > 0) {
            System.out.println("message : " + msgStr);

            Message msg = new Message();

            msg.setUser(user);
            msg.setMessage(msgStr);
            msg.setTime(new Date());

            boolean isSend = DAOFactory.getMessageDAO().saveMessage(msg);
            if (isSend) {
                response.getWriter().write("info : 'message send successfully'");
            } else {
                response.getWriter().write("{info: 'message not send'}");
            }
        } else {
            response.getWriter().write("{info: 'not authorized user'}");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ChatServlet : Ajax request update chat");

        try {
            int messageId = Integer.parseInt(request.getParameter("messageId"));
            StringBuilder messagesReturn = new StringBuilder();

            List<Message> messageList = DAOFactory.getMessageDAO().loadAllMessage();

            if (messageList != null) {
                for (Message msg : messageList) {
                    if (messageId < msg.getId())
                        messagesReturn.append(getMessageHTML(msg));
                }
            }
            response.getWriter().print(messagesReturn.toString());
        }catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

    }


    public String getMessageHTML (Message message) {
        return  "<div id=\""+message.getId()+"\" class=\"item\">\n" +
                "              <img src=\"/dist/img/profile.jpg\" alt=\"user image\" class=\"online\"/>\n" +
                "              <p class=\"message\">\n" +
                "                <a href=\"#\" class=\"name\">\n" +
                "                  <small class=\"text-muted pull-right\"><i class=\"fa fa-clock-o\"></i> "+message.getTime()+" </small>\n" +
                "                  "+message.getUser().getFullName()+"\n" +
                "                </a>\n" +
                "                "+message.getMessage()+"\n" +
                "              </p>\n" +
                "\n" +
                "            </div><!-- /.item -->";
    }
}
