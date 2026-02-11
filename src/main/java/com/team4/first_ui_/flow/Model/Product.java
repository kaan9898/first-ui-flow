package com.team4.first_ui_.flow.Model;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Product {
    private int ProductId;
    private String ProductName;
    private String ProductCategory;
    private Double ProductPrice;

    public Product(int ProductId, String ProductName, String ProductCategory, Double ProductPrice) {
        this.ProductId = ProductId;
        this.ProductName = ProductName;
        this.ProductCategory = ProductCategory;
        this.ProductPrice = ProductPrice;
    }

}
