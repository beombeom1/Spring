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
    String user_name;

    @Column
    String user_age;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }

    public EntityUser() {
        this.id = -1;
        this.user_name = "";
        this.user_age = "";
    }

    public EntityUser(int id, String user_name, String user_age) {
        super();
        this.id = -1;
        this.user_name = user_name;
        this.user_age = user_age;
    }

    @Override
    public String toString() {
        return "EntityUser [id=" + id + ", user_name=" + user_name + ", user_age=" + user_age + "]";
    }

}
