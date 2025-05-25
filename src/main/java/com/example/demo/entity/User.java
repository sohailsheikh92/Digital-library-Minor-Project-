package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String uname;
    private String uemail;

    public User(String uname, String uemail) {
//        this.uid = uid;
        this.uname = uname;
        this.uemail = uemail;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public int getUid() {
        return uid;
    }

    public String getUname() {
        return uname;
    }

    public String getUemail() {
        return uemail;
    }
    public User() {
    }
}
