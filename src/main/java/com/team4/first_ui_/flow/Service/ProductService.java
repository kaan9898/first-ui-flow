package com.team4.first_ui_.flow.Service;

import com.team4.first_ui_.flow.Model.Product;
import com.team4.first_ui_.flow.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository ProductRepository;

    public ProductService(ProductRepository ProductRepository) {
        this.ProductRepository = ProductRepository;
    }

    public List<Product> getAllProducts() {
        return ProductRepository.findAll();
    }

    public void saveProduct(Product Product) {
        ProductRepository.save(Product);
    }

    public void deleteProductById(Long id) {
        ProductRepository.deleteById(id);
    }

}