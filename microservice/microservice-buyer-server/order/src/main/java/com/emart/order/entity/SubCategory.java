package com.emart.order.entity;

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

@Data
@NoArgsConstructor
public class SubCategory implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String subCategoryId;

    private String subCategory_name;

    private String categoryId;

    private String itemId;
    
    private String item_name;
    
    private String sellerId;
    
    private String brief_details;

    private String nw_type;

    private String memory_Storage;

    private String nettwork_type;

    private String cameras;
    
    private String os_version;
    
    private double gst;

}