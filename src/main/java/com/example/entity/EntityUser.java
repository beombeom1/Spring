package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EntityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String username;

    @Column
    String userage;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return username;
    }

    public void setUser_name(String user_name) {
        this.username = user_name;
    }

    public String getUser_age() {
        return userage;
    }

    public void setUser_age(String user_age) {
        this.userage = user_age;
    }

    public EntityUser() {
        this.id = -1;
        this.username = "";
        this.userage = "";
    }

    public EntityUser(int id, String user_name, String user_age) {
        super();
        this.id = -1;
        this.username = user_name;
        this.userage = user_age;
    }

    @Override
    public String toString() {
        return "EntityUser [id=" + id + ", user_name=" + username + ", user_age=" + userage + "]";
    }

}
