package com.example.dto;

import com.example.entity.EntityBoard;

public class DTOBoard {
    private int id;
    private String Title;
    private String Content;
    private String Writer;
    private String Date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public EntityBoard toEntity() {
        EntityBoard entity = new EntityBoard();
        entity.setTitle(this.Title);
        entity.setContent(this.Content);
        entity.setWriter(this.Writer);
        entity.setDate(this.Date);
        return entity;
    }
}
