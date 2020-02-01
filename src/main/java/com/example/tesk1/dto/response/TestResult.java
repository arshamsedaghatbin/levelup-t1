package com.example.tesk1.dto.response;

public class TestResult {

private String text;
private Integer id;


    @Override
    public String toString() {
        return "TestResult{" +
                "text='" + text + '\'' +
                ", id=" + id +
                '}';
    }

    public String getText() {
return text;
}

public void setText(String text) {
this.text = text;
}

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

}