package com.course.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.course.entities.Order;
import com.course.course.entities.User;
import com.course.course.repository.OrderRepository;
import com.course.course.repository.UserRepository;

@Configuration
@Profile("test") 
public class TestConfig implements CommandLineRunner{
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;

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

    Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
    Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
    Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

    userRepository.saveAll(Arrays.asList(u1, u2));
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
  }
}
