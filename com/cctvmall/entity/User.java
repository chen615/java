package com.cctvmall.entity;

import java.io.Serializable;

public class User implements Serializable
{
    private int id;
    private String username;
    private int age;
    
    public User()
    {
        // super();
    }
    /*
    public User(int id, String username, int age)
    {
        super();
        this.id = id;
        this.username = username;
        this.age = age;
    } */
    
    public int getId()
    {
        return this.id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    
    public int getAge()
    {
        return this.age;
    }
}