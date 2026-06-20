package com.sahil.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.Entity.Category;
import com.sahil.Exception.ResourceNotFoundException;
import com.sahil.Repo.CategoryRepo;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public Category saveCategory(
            Category category) {

        return categoryRepo.save(category);
    }

    public List<Category> getAllCategories() {

        return categoryRepo.findAll();
    }

    public Category getCategoryById(Long id) {

        return categoryRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Category Not Found"));
    }

    public Category updateCategory(
            Long id,
            Category category) {

        Category existingCategory =
                getCategoryById(id);

        existingCategory.setCategoryName(
                category.getCategoryName());

        existingCategory.setDescription(
                category.getDescription());

        return categoryRepo.save(
                existingCategory);
    }

    public void deleteCategory(Long id) {

        Category category =
                getCategoryById(id);

        categoryRepo.delete(category);
    }
}