package com.web.hibernate;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by eltntawy on 27/03/15.
 */
@Entity
@Table(name = "Message", schema = "", catalog = "Chat_DB")
public class MessageEntity {
    private int id;
    private String message;
    private Collection<UserSendMessageEntity> userSendMessagesById;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "message", nullable = true, insertable = true, updatable = true, length = 45)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (id != that.id) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "messageByMessageId")
    public Collection<UserSendMessageEntity> getUserSendMessagesById() {
        return userSendMessagesById;
    }

    public void setUserSendMessagesById(Collection<UserSendMessageEntity> userSendMessagesById) {
        this.userSendMessagesById = userSendMessagesById;
    }
}
