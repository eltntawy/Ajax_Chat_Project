package com.web.servlet;

import com.web.bean.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by eltntawy on 22/03/15.
 */
@WebServlet(urlPatterns = "/ChatServlet")
public class ChatServlet extends HttpServlet {

    private static Vector<Message> chatVector = new Vector<Message>();
    private static int messageCounter = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
        String username = request.getParameter("username");
        String msg = request.getParameter("message");

        Message message = new Message();
        message.setId(messageCounter++);
        message.setSender(username);
        message.setMessage(msg);

        chatVector.add(message);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");

        int messageId = Integer.parseInt(request.getParameter("messageId"));
        StringBuilder messagesReturn = new StringBuilder();

        for(Message msg : chatVector) {
            if(messageId < msg.getId() )
                messagesReturn.append(msg.getMessageHTML());
        }

        response.getWriter().print(messagesReturn.toString());


    }
}
