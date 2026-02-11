package com.team4.first_ui_.flow.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private Double ProductPrice;

    public Product(int ProductId, String ProductName, String ProductCategory, Double ProductPrice) {
        this.ProductId = ProductId;
        this.ProductName = ProductName;
        this.ProductCategory = ProductCategory;
        this.ProductPrice = ProductPrice;
    }

}