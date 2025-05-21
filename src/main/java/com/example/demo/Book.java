package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "my_books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid;
    private String bname;
    private String bauthor;
    private String bpublicationyear;
    private String btype;

    public void setBid(int bid) {
        this.bid = bid;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void setBpublicationyear(String bpublicationyear) {
        this.bpublicationyear = bpublicationyear;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public int getBid() {
        return bid;
    }

    public String getBname() {
        return bname;
    }

    public String getBauthor() {
        return bauthor;
    }

    public String getBpublicationyear() {
        return bpublicationyear;
    }

    public String getBtype() {
        return btype;
    }
}
