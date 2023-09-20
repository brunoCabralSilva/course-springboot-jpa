package com.course.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> { }
