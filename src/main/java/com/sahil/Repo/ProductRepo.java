package com.sahil.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.Entity.Product;

public interface ProductRepo
        extends JpaRepository<Product, Long> {

}