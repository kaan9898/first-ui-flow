package com.team4.first_ui_.flow.Repository;

import com.team4.first_ui_.flow.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> Products = new ArrayList<>();
    private int counter = 1;

    @Override
    public List<Product> findAll() {
        return Products;
    }

    @Override
    public void save(Product Product) {
        Product.setProductId(counter++);
        Products.add(Product);
    }

    @Override
    public void deleteById(Long id) {
        Products.removeIf(Product -> Product.getProductId() == id);
    }
}