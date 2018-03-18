package com.example.tiberium.hrtt.Models;

import java.io.Serializable;

/**
 * Created by TIBERIUM on 26.10.2017.
 */

public class News implements Serializable {
    int id;
    String title;
    String content;
    String data;


    public void setContent(String content) {
        this.content = content;
    }

    public News(String title, String data) {

        this.title = title;
        this.data = data;

    }

    public News(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getData() {
        return data;
    }
}
