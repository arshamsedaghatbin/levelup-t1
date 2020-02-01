package com.example.tesk1.dto.request;

import java.io.Serializable;

public class TestRequest implements Serializable {


    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
