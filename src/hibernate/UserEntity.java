package com.web.hibernate;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by eltntawy on 27/03/15.
 */
@Entity
@Table(name = "User", schema = "", catalog = "Chat_DB")
public class UserEntity {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private Collection<UserSendMessageEntity> userSendMessagesById;
    private Collection<UserSendMessageEntity> userSendMessagesById_0;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fullName", nullable = true, insertable = true, updatable = true, length = 500)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 500)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 500)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByFromUser")
    public Collection<UserSendMessageEntity> getUserSendMessagesById() {
        return userSendMessagesById;
    }

    public void setUserSendMessagesById(Collection<UserSendMessageEntity> userSendMessagesById) {
        this.userSendMessagesById = userSendMessagesById;
    }

    @OneToMany(mappedBy = "userByToUser")
    public Collection<UserSendMessageEntity> getUserSendMessagesById_0() {
        return userSendMessagesById_0;
    }

    public void setUserSendMessagesById_0(Collection<UserSendMessageEntity> userSendMessagesById_0) {
        this.userSendMessagesById_0 = userSendMessagesById_0;
    }
}
