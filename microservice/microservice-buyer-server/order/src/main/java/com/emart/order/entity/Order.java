package com.emart.order.entity;

import java.io.Serializable;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
// @Table(name = "tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // private long id;


    // private List<Item> listItem;

}