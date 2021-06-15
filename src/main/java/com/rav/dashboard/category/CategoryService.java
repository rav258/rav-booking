package com.rav.dashboard.category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(int theId);

    void save(Category theProduct);

    void deleteById(int theId);

}
