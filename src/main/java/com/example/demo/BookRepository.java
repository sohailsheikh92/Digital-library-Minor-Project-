package com.example.demo;

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
}
