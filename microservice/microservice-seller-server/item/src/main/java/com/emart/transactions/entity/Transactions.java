package com.emart.transactions.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_transactions")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Transactions implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "sellerId")
    private String sellerId;

    @Column(name = "itemId")
    private String itemId;
    
    @Column(name = "categoryId")
    private String categoryId;

    @Column(name = "subCategoryId")
    private String subCategoryId;

    @Column(name = "num_items")
    private int num_items;

    @CreatedDate
    @Column(name = "creat_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String creat_date;

}