package com.library.service;

import com.example.demo.Book;
import com.library.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    public Book addBook(Book mybook){
        return repo.save(mybook);
    }
}
