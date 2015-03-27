package com.hibernate.pojo;
// Generated Mar 27, 2015 2:25:48 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "User" , catalog = "Chat_DB"
)
public class User implements java.io.Serializable {


    private Integer id;
    private String fullName;
    private String email;
    private String password;
    private Set<Message> messagesForToUser = new HashSet<Message>(0);
    private Set<Message> messagesForFromUser = new HashSet<Message>(0);

    public User() {
    }


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String fullName, String email, String password, Set<Message> messagesForToUser, Set<Message> messagesForFromUser) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.messagesForToUser = messagesForToUser;
        this.messagesForFromUser = messagesForFromUser;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)


    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "fullName", length = 500)
    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    @Column(name = "email", nullable = false, length = 500)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name = "password", nullable = false, length = 500)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userByToUser")
    public Set<Message> getMessagesForToUser() {
        return this.messagesForToUser;
    }

    public void setMessagesForToUser(Set<Message> messagesForToUser) {
        this.messagesForToUser = messagesForToUser;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userByFromUser")
    public Set<Message> getMessagesForFromUser() {
        return this.messagesForFromUser;
    }

    public void setMessagesForFromUser(Set<Message> messagesForFromUser) {
        this.messagesForFromUser = messagesForFromUser;
    }


}

