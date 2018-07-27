package com.edu.ncu.drawlandmark;

public class User {

    public String name;
    public String email;
    public String UID;
    public String parent_setting;
    public String porfolio;
    public String profile_picture;

    public User(){

    }

    public User(String UID){
        this.UID = UID;
    }

    public User(String email, String name){
        this.email = email;
        this.name = name;
    }

    public User(String uid, String email, String name){
        this.UID = uid;
        this.email = email;
        this.name = name;
    }


}
