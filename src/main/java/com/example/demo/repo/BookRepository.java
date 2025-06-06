package com.example.demo.repo;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book,Integer>{

    @Query("SELECT b FROM Book b WHERE " +
            "b.bname LIKE %:keyword% OR " +
            "b.bauthor LIKE %:keyword% OR " +
            "b.btype LIKE %:keyword%")
    List<Book> searchBooks(@Param("keyword") String keyword);

    List<Book> findByBname(String bname);


    List<Book> findByBtypeIgnoreCase(String btype);
//
    List<Book> findByBpublicationyear(String bpublicationyear);

    List<Book> findByBauthor(String bauthor);

    //for sorting->
    List<Book> findAllByOrderByBnameAsc();

}
