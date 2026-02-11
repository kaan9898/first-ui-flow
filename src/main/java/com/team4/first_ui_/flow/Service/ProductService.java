package com.team4.first_ui_.flow.Service;

import com.team4.first_ui_.flow.Model.Product;
import com.team4.first_ui_.flow.Repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Page<Product> getProductsPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ProductRepository.findAll(pageable);
    }

    public Page<Product> getProductsSorted(String sortBy, String sortDir, int page, int size) {

        Sort sort = Sort.unsorted();

        if (sortBy != null && sortDir != null) {
            if (sortBy.equals("name")) {
                sort = sortDir.equals("asc") ? Sort.by("productName").ascending() : Sort.by("productName").descending();
            } else if (sortBy.equals("price")) {
                sort = sortDir.equals("asc") ? Sort.by("productPrice").ascending() : Sort.by("productPrice").descending();
            }
        }

        Pageable pageable = PageRequest.of(page, size, sort);
        return ProductRepository.findAll(pageable);
    }
}