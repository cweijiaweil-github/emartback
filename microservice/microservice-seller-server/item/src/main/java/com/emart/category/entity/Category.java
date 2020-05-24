package com.emart.category.entity;

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
@Table(name = "t_category")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Category implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "categoryId")
    private String categoryId;

    @NotNull
    @Column(name = "category_name")
    private String category_name;
    
    @NotNull
    @Column(name = "sellerId")
    private String sellerId;

    @Column(name = "brief_details")
    private String brief_details;

}