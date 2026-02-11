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
    private int productId;
    @Column(name = "name")
    @NotBlank(message = "name is required")
    private String productName;
    @Column(name = "category")
    @NotBlank(message = "Category is required")
    private String productCategory;
    @Column(name = "price")
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private Double productPrice;

    public Product(int productId, String productName, String productCategory, Double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
    }

}