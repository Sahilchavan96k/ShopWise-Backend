package com.sahil.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}