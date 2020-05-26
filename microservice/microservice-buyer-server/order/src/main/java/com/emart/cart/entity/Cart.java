package com.emart.cart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_cart")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
// @AllArgsConstructor
public class Cart  implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name = "buyerId")
    private String buyerId;
    
    @Column(name = "cartId")
    private String cartId;
    
    @NotNull
    @Column(name = "itemId")
    private String itemId;

    @Column(name = "item_name")
    private String item_name;
    
    @Column(name = "categoryId")
    private String categoryId;

    @Column(name = "subcategoryId")
    private String subcategoryId;

    @Column(name = "price")
    private double price;

    @Column(name = "num_items")
    private int num_items;

    @CreatedDate
    @Column(name = "creat_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String creat_date;
}