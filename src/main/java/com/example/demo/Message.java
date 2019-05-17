package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=2)
    private String title;

    @NotNull
    @Size(min=2)
    private String content;

    @NotNull
    @Size(min=1)
    private String posteddate;
    @NotNull
    @Size(min=1)
    private String postedby;

    public Message(@NotNull @Size(min = 2) String title, @NotNull @Size(min = 2) String content, @NotNull @Size(min = 1) String posteddate, @NotNull @Size(min = 1) String postedby) {
        this.title = title;
        this.content = content;
        this.posteddate = posteddate;
        this.postedby = postedby;
    }

    public Message() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPosteddate() {
        return posteddate;
    }

    public void setPosteddate(String posteddate) {
        this.posteddate = posteddate;
    }

    public String getPostedby() {
        return postedby;
    }

    public void setPostedby(String postedby) {
        this.postedby = postedby;
    }
}
