package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repo.BorrowRepo;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository urepo;

    public User addData(User user){
        return urepo.save(user);
    }

    public List<User> getData(){
        return urepo.findAll();
    }
}
