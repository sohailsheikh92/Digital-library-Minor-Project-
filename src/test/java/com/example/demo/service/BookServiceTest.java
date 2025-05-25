package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookRepository bookRepo;
    @InjectMocks
    private BookService bookservice;


    @Test
    public void addBookTest(){
        Book book=new Book();
        book.setBid(101);
        book.setBname("Java");
        book.setBauthor("Faizul sir");
        book.setBpublicationyear("2023");
        book.setBtype("Technical");
        Mockito.when(bookRepo.save(book)).thenReturn(book);
        Book thebook=bookservice.addBook(book);
        Assertions.assertEquals(101,thebook.getBid());
        Assertions.assertEquals("Java",book.getBname());
        Assertions.assertEquals(book.getBauthor(), thebook.getBauthor());
        Assertions.assertEquals(book.getBpublicationyear(), thebook.getBpublicationyear());
        Assertions.assertEquals(book.getBtype(), thebook.getBtype());
        Assertions.assertTrue(thebook.getBid()==101);
    }
}
