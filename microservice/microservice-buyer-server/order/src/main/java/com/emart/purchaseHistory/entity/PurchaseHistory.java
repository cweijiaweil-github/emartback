package com.emart.purchaseHistory.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_purchaseHistory")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class PurchaseHistory implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "itemId")
    private String itemId;
    
    @NotNull
    @Column(name = "categoryId")
    private String categoryId;

    @NotNull
    @Column(name = "subcategoryId")
    private String subcategoryId;

    @Column(name = "buyerId")
    private String buyerId;

    @NotNull
    @Column(name = "sellerId")
    private String sellerId;
    
    @Column(name = "transactIionId")
    private String transactIionId;
    
    @Column(name = "num_items")
    private int num_items;

    @Column(name = "remark")
    private String remark;
    
}