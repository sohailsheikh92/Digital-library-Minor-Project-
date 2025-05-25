package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
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
    @GetMapping("/filterBname/{bname}")
    public List<Book> filterByBname(@PathVariable String bname){
        return service.filtertByBname(bname);
    }

    @GetMapping("/filterBtype/{btype}")
    public List<Book> filterByBtype(@PathVariable String btype){
        return service.filterByBtype(btype);
    }
    @GetMapping("/filterBpubliyear/{bpublicationyear}")
    public List<Book> filterByBpublicationYear(@PathVariable String bpublicationyear){
        return service.filterByBpublicationyear(bpublicationyear);
    }
    @GetMapping("/filterBauthorname/{bauthor}")
    public List<Book> filterByBauthorname(@PathVariable String bauthor){
        return service.filterByBauthor(bauthor);
    }
    @GetMapping("/sortbyBname")
    public List<Book> sortByBname(){
            return service.sortBname();
    }

}
