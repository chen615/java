package com.cctvmall.entity;

import java.util.Date;

public class Question
{
    private int id;
    private String question_text;
    private Date pub_date;
    private String username;

    public Question(int id, String question_text, /* Date pub_date, */ String username)
    {
        this.id = id;
        this.question_text = question_text;
        // this.pub_date = pub_date;
        this.username = username;
    }
}
