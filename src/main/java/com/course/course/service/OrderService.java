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
  private OrderRepository orderRepository;

  public List<Order> findAll() {
    return orderRepository.findAll();
  }

  public Order findById(Long id) {
    Optional<Order> object = orderRepository.findById(id);
    return object.get();
  }
}
