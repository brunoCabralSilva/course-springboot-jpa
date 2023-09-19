package com.course.course.resources;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
  
  @GetMapping
  public ResponseEntity<User> findAll() {
    User user = new User();
    user.setName("bruno");
    user.setEmail("bruno@gmail.com");
    user.setPhone("+55 83 998364408");
    user.setPassword("123456");
    return ResponseEntity.ok().body(user);
  };
}
