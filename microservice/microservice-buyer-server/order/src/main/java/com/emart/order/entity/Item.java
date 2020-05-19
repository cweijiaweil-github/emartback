package com.emart.order.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item  implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long id;
    
    private String itemId;
    
    private String item_name;
    
    private String sellerId;

    private String categoryId;

    private String subcategoryId;

    private Double price;

    private String description;

    private int stock_number;

    private String remarks;

    private String creat_date;
}