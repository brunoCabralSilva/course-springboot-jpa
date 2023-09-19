package com.course.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.course.entities.Order;
import com.course.course.repository.OrderRepository;

@Service
public class OrderService {
  
  @Autowired
  private OrderRepository OrderRepository;

  public List<Order> findAll() {
    return OrderRepository.findAll();
  }

  public Order findById(Long id) {
    Optional<Order> object = OrderRepository.findById(id);
    return object.get();
  }
}
