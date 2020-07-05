package com.sakeriniwebsite.emusicstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = -982600930252544962L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    @NotEmpty(message = "Product name is required")
    private String productName;
    private String productCategory;
    private String productDescription;

    @Min(value = 0, message = "Product price must not be less than zero")
    private double productPrice;
    private String productCondition;
    private String productStatus;

    @Min(value = 0, message = "Unit in stock can not be less than zero")
    private int unitInStock;
    private String productManufacturer;

    @Transient // we dont want this file to be persistance so that why we put Transient ...
    private MultipartFile productImage;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore //broken loop
    private List<CartItem> cartItemList;
}
