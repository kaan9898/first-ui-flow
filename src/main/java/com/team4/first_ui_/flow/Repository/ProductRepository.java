package com.team4.first_ui_.flow.Repository;

import com.team4.first_ui_.flow.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
