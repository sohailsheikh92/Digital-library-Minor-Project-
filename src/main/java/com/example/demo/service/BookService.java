package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    public Book addBook(Book mybook){

        return repo.save(mybook);
    }

    public List<Book> getAllBook(){
        return repo.findAll();
    }
    public Optional<Book> getSingleBook(int id){
        return repo.findById(id);
    }

    
    public Book updateBook(int id,Book book){
        Optional<Book> thebook=repo.findById(id);
        Book newBook = thebook.get();
        newBook.setBname(book.getBname());
        newBook.setBauthor(book.getBauthor());
        newBook.setBtype(book.getBtype());
        newBook.setBpublicationyear(book.getBpublicationyear());
        return repo.save(newBook);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public List<Book> searchBook(String keywords){
        return repo.searchBooks(keywords);
    }

    public List<Book> filtertByBname(String bname){
        return repo.findByBname(bname);
    }

    public List<Book> filterByBtype(String btype){
        return repo.findByBtypeIgnoreCase(btype);
    }

    public List<Book> filterByBpublicationyear(String bpublicationyear){
        return repo.findByBpublicationyear(bpublicationyear);
    }
    public List<Book> filterByBauthor(String bauthor){
        return repo.findByBauthor(bauthor);
    }

    public List<Book> sortBname(){
        return repo.findAllByOrderByBnameAsc();
    }
}
