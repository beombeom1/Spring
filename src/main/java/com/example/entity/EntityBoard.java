package com.example.entity;

import jakarta.persistence.*;

@Entity
public class EntityBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    int id;
    @Column
    String Title;
    @Column
    String Content;
    @Column
    String Writer;
    @Column
    String Date;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}
}
