package com.example.productservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
    private String info;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId")
    List<ProductEntity> productEntityList = new ArrayList<>();
    public Category(String categoryName, String info) {
        this.categoryName = categoryName;
        this.info = info;
    }

    public Category(String categoryName, String info, List<ProductEntity> productEntityList) {
        this.categoryName = categoryName;
        this.info = info;
        this.productEntityList = productEntityList;
    }
}
