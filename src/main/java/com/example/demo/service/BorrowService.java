package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Borrow;
import com.example.demo.entity.User;
import com.example.demo.repo.BookRepository;
import com.example.demo.repo.BorrowRepo;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BorrowService {
    @Autowired
    private UserRepository userrepo;
    @Autowired
    private BookRepository bookrepo;
    @Autowired
    private BorrowRepo borrepo;

//    This method is used to borrow a book for a user. It connects a user and a book, and also saves the date on which the book was borrowed.
    public Borrow borrowBooks(int uid,int bid){ //uid means user id and bid means book id
        User user=userrepo.findById(uid).orElseThrow(()->new RuntimeException("User not Found"));

        Book book=bookrepo.findById(bid).orElseThrow(()-> new RuntimeException("Books not found"));

        Borrow borrow=new Borrow();
        //which user have borrowed
        borrow.setBook(book);
        //which book have borrowed
        borrow.setUser(user);
        //on which date book have borrowed
        borrow.setBorrowDate(new Date());


        return borrepo.save(borrow);

    }

    public Borrow returnBooks(int borrowId){
        Borrow borrow=borrepo.findById(borrowId).orElseThrow(()->new RuntimeException("No record found"));
        borrow.setReturnDate(new Date());
        return borrepo.save(borrow);
    }

    public List<Borrow> getBorrow(){
        return borrepo.findAll();
    }

    public void deleteBorrow(int id){
        borrepo.deleteById(id);
    }
}
