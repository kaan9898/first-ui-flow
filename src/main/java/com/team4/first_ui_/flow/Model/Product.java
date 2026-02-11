package com.team4.first_ui_.flow.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity(name = "product")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ProductId;
    @Column(name = "name")
    @NotBlank(message = "name is required")
    private String ProductName;
    @Column(name = "category")
    @NotBlank(message = "Category is required")
    private String ProductCategory;
    @Column(name = "price")
    @NotBlank(message = "price is required")
    private Double ProductPrice;

    public Product(int ProductId, String ProductName, String ProductCategory, Double ProductPrice) {
        this.ProductId = ProductId;
        this.ProductName = ProductName;
        this.ProductCategory = ProductCategory;
        this.ProductPrice = ProductPrice;
    }

}