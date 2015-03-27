package com.web.hibernate;

import com.web.hibernate.MessageEntity;
import com.web.hibernate.UserEntity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by eltntawy on 27/03/15.
 */
@Entity
@Table(name = "User_send_Message", schema = "", catalog = "Chat_DB")
public class UserSendMessageEntity {
    private int id;
    private Timestamp time;
    private UserEntity userByFromUser;
    private MessageEntity messageByMessageId;
    private UserEntity userByToUser;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time", nullable = true, insertable = true, updatable = true)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSendMessageEntity that = (UserSendMessageEntity) o;

        if (id != that.id) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fromUser", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByFromUser() {
        return userByFromUser;
    }

    public void setUserByFromUser(UserEntity userByFromUser) {
        this.userByFromUser = userByFromUser;
    }

    @ManyToOne
    @JoinColumn(name = "Message_id", referencedColumnName = "id", nullable = false)
    public MessageEntity getMessageByMessageId() {
        return messageByMessageId;
    }

    public void setMessageByMessageId(MessageEntity messageByMessageId) {
        this.messageByMessageId = messageByMessageId;
    }

    @ManyToOne
    @JoinColumn(name = "toUser", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByToUser() {
        return userByToUser;
    }

    public void setUserByToUser(UserEntity userByToUser) {
        this.userByToUser = userByToUser;
    }
}
