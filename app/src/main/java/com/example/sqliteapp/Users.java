package com.example.sqliteapp;

public class Users {
    int id;
    String user_name;
    String name;
    String password;



//    public Users(int id, String user_name, String name, String password) {
//        this.id = id;
//        this.user_name = user_name;
//        this.name = name;
//        this.password = password;
//    }
    public Users( String user_name, String name, String password) {
        this.user_name = user_name;
        this.name = name;
        this.password = password;
    }
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
