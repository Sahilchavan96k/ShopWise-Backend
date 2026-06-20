package com.sahil.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.Entity.Product;
import com.sahil.Exception.ResourceNotFoundException;
import com.sahil.Repo.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product saveProduct(
            Product product) {

        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {

        return productRepo.findAll();
    }

    public Product getProductById(
            Long id) {

        return productRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product Not Found"));
    }

    public Product updateProduct(
            Long id,
            Product product) {

        Product existingProduct =
                getProductById(id);

        existingProduct.setProductName(
                product.getProductName());

        existingProduct.setPrice(
                product.getPrice());

        existingProduct.setStock(
                product.getStock());

        existingProduct.setImageUrl(
                product.getImageUrl());

        existingProduct.setCategory(
                product.getCategory());

        return productRepo.save(
                existingProduct);
    }

    public void deleteProduct(
            Long id) {

        Product product =
                getProductById(id);

        productRepo.delete(product);
    }

}