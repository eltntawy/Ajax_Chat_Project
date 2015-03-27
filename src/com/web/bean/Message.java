/**
 * Created by eltntawy on 22/03/15.
 */

package com.web.bean;

public class Message {


    private int id;
    private String sender;
    private String Message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }


    public String getMessageHTML () {
        return "<div id=\""+getId()+"\" class=\"item\">\n" +
                "              <img src=\"dist/img/user4-128x128.jpg\" alt=\"user image\" class=\"online\"/>\n" +
                "              <p class=\"message\">\n" +
                "                <a href=\"#\" class=\"name\">\n" +
                "                  <small class=\"text-muted pull-right\"><i class=\"fa fa-clock-o\"></i> 2:15</small>\n" +
                "                  "+getSender()+"\n" +
                "                </a>\n" +
                "                "+getMessage()+"\n" +
                "              </p>\n" +
                "\n" +
                "            </div><!-- /.item -->";
    }

}
