package com.team4.first_ui_.flow.Repository;

import com.team4.first_ui_.flow.Model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();
    void save(Product Product);
    void deleteById(Long id);
}
