package com.course.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.course.entities.Category;
import com.course.course.entities.Order;
import com.course.course.entities.Product;
import com.course.course.entities.User;
import com.course.course.enums.OrderStatus;
import com.course.course.repository.CategoryRepository;
import com.course.course.repository.OrderRepository;
import com.course.course.repository.ProductRepository;
import com.course.course.repository.UserRepository;

@Configuration
@Profile("test") 
public class TestConfig implements CommandLineRunner{
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired ProductRepository productRepository;

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

    Order o1 = new Order(
      null,
      Instant.parse("2019-06-20T19:53:07Z"),
      u1,
      OrderStatus.WAITING_PAYMENT
    );

    Order o2 = new Order(
      null,
      Instant.parse("2019-07-21T03:42:10Z"),
      u2,
      OrderStatus.PAID
    );

    Order o3 = new Order(
      null,
      Instant.parse("2019-07-22T15:21:22Z"),
      u1,
      OrderStatus.CANCELED
    );

    Category cat1 = new Category(null, "Electronics");
    Category cat2 = new Category(null, "Books");
    Category cat3 = new Category(null, "Computers");

    Product p1 = new Product(
      null,
      "The Lord of the Rings",
      "Lorem ipsum dolor sit amet, consectetur.",
      90.5,
      null,
      cat2
    );

    Product p2 = new Product(
      null,
      "Smart TV",
      "Nulla eu imperdiet purus. Maecenas ante.",
      2190.0,
      "",
      cat1
    );

    Product p3 = new Product(
      null,
      "Macbook Pro",
      "Nam eleifend maximus tortor, at mollis.",
      1250.0,
      "",
      cat3
    );

    Product p4 = new Product(
      null,
      "PC Gamer",
      "Donec aliquet odio ac rhoncus cursus.",
      1200.0,
      "",
      cat3
    );

    Product p5 = new Product(
      null,
      "Rails for Dummies",
      "Cras fringilla convallis sem vel faucibus.",
      100.99,
      "",
      cat1  
    );
    
    userRepository.saveAll(Arrays.asList(u1, u2));
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
  }
}
