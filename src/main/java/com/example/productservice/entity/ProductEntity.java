package com.example.productservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String info;
    private int price;
    private int stock;

    public ProductEntity(String productName, String info, int price, int stock) {
        this.productName = productName;
        this.info = info;
        this.price = price;
        this.stock = stock;
    }
    //    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "category_id")
//    private CategoryEntity category;

//    public ProductEntity(String productName, String info, int price, int stock, CategoryEntity category) {
//        this.productName = productName;
//        this.info = info;
//        this.price = price;
//        this.stock = stock;
////        this.category = category;
//    }
}
