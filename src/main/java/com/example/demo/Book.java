package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="myBooks")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bid;
    private String bname;
    private String bauthor;
    private String bpublicationyear;
    private String btype;
}
