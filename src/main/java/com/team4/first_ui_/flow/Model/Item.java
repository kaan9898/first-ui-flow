package com.team4.first_ui_.flow.Model;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Item {
    private int itemId;
    private String itemName;
    private String itemCategory;
    private Double itemPrice;

    public Item(int itemId, String itemName, String itemCategory, Double itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
    }

}
