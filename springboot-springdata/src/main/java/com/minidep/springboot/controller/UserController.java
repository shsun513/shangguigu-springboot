package com.minidep.springboot.controller;

import com.minidep.springboot.entity.User;
import com.minidep.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        System.out.println(id+"infoid");
        User user = userRepository.getOne(id);
        return user;
    }

    @GetMapping("/user1/{id1}")
    public User getUser1(@PathVariable("id1") Integer id){
        System.out.println(id);
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.get();
    }

    @GetMapping("/user")
    public User addUser1(User user){
        User save = userRepository.save(user);
        return save;
    }

}
