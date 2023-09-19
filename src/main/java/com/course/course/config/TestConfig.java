package com.course.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.course.course.UserRepository;
import com.course.course.entities.User;

@Configuration
public class TestConfig implements CommandLineRunner{
  
  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) {
    User u1 = new User();
    u1.setName("bruno");
    u1.setEmail("bruno@gmail.com");
    u1.setPhone("+55 83 998364408");
    u1.setPassword("123456");
    
    User u2 = new User();
    u2.setName("ysla");
    u2.setEmail("ysla@gmail.com");
    u2.setPhone("+55 83 996729765");
    u2.setPassword("654321");

    userRepository.saveAll(Arrays.asList(u1, u2));
  }
}
