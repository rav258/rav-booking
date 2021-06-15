package com.rav.dashboard.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int theId) {
        Optional<Category> result = categoryRepository.findById(theId);

        Category theProduct = null;

        if (result.isPresent()) {
            theProduct = result.get();
        } else {
            // we didn't find the product
            throw new RuntimeException("Did not find product id - " + theId);
        }

        return theProduct;
    }


    @Override
    public void save(Category theProduct) {
        categoryRepository.save(theProduct);

    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }



}
