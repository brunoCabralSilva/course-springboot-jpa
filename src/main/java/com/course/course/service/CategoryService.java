package com.course.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.course.entities.Category;
import com.course.course.repository.CategoryRepository;

@Service
public class CategoryService {
  
  @Autowired
  private CategoryRepository categoryRepository;

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Category findById(Long id) {
    Optional<Category> object = categoryRepository.findById(id);
    return object.get();
  }
}
