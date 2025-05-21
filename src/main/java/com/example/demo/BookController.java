package com.example.demo;

import jdk.jfr.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
        @Autowired
        private BookService service;

        @PostMapping("/save")
        public String saveBook(@RequestBody Book mybook){
            service.addBook(mybook);
            return "Successfully";
        }
        @GetMapping("/findBook")
        public List<Book> getBook(){
            return service.getAllBook();
//            return "I got book";
        }
        @GetMapping("/onebook/{id}")
        public Optional<Book> getSingleBook(@PathVariable int id){
            return service.getSingleBook(id);
        }
        @PutMapping("/update/{id}")
        public Book updateBook(@PathVariable int id,@RequestBody Book book){
            return service.updateBook(id,book);
        }

        @DeleteMapping("/delete/{id}")
        public void deleteBook(@PathVariable int id){
            service.delete(id);
        }

        @GetMapping("/search/{keyword}")
        public List<Book> search(@PathVariable String keyword){
            return service.searchBook(keyword);
        }

}
