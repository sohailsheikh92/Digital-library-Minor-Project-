package com.example.demo.controller;

import com.example.demo.entity.Borrow;
import com.example.demo.service.BorrowService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private BorrowService bservice;

    //the below function is for adding data in borrow table
    @PostMapping("/addData")
    public Borrow borrowBooks(@RequestParam int userid,@RequestParam int bid){
        return bservice.borrowBooks(userid, bid);
    }

    //the below fun adds returnDate to a existing borrowid
    @PutMapping("/returnDate")
    public Borrow returnBook(@RequestParam int bid){
        return bservice.returnBooks(bid);
    }

    //the below fun retrieves all records of borrow table
    @GetMapping("/getBorrow")
    public List<Borrow> getBorrow(){
        return bservice.getBorrow();
    }

    //the below fun is for deleteing any specific borrow record
    @DeleteMapping("/delteborrow/{bid}")
    public void delete(@PathVariable int bid){
        bservice.deleteBorrow(bid);
    }


}
