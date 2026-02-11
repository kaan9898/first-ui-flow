package com.team4.first_ui_.flow.Service;

import com.team4.first_ui_.flow.Model.Product;
import com.team4.first_ui_.flow.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository ProductRepository;

    public ProductService(ProductRepository productRepository) {
        this.ProductRepository = productRepository;
    }

    private Product mapToEntity(Product product) {
        return Product.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productCategory(product.getProductCategory())
                .productPrice(product.getProductPrice())
                .build();
    }

    public List<Product> getAllProducts() {
        return ProductRepository.findAll();
    }

    public void saveProduct(Product product) {
        Product entity = mapToEntity(product);
        ProductRepository.save(entity);
    }

    public void deleteProductById(Long id) {
        ProductRepository.deleteById(id.intValue());
    }

}