package com.course.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.course.entities.User;
import com.course.course.repository.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(Long id) {
    Optional<User> object = userRepository.findById(id);
    return object.get();
  }
}
