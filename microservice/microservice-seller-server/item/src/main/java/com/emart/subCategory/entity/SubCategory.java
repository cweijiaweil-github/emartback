package com.emart.subCategory.entity;

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
@Table(name = "t_subCategory")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class SubCategory implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "subCategoryId")
    private String subCategoryId;

    @NotNull
    @Column(name = "subCategory_name")
    private String subCategory_name;

    @NotNull
    @Column(name = "categoryId")
    private String categoryId;

    @NotNull
    @Column(name = "sellerId")
    private String sellerId;
    
    @Column(name = "brief_details")
    private String brief_details;

    @Column(name = "nw_type")
    private String nw_type;

    @Column(name = "memory_Storage")
    private String memory_Storage;

    @Column(name = "nettwork_type")
    private String nettwork_type;

    @Column(name = "cameras")
    private String cameras;
    
    @Column(name = "os_version")
    private String os_version;
    
    @Column(name = "gst")
    private double gst;

}