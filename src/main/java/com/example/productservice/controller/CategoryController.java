package com.example.productservice.controller;

import com.example.productservice.dto.CategoryRequest;
import com.example.productservice.dto.CategoryResponse;
import com.example.productservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/product")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;
    @PostMapping("/category/create")
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequest requestdto){
       service.write(requestdto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/category/list")
    public List<CategoryResponse> categorylist(){
        return service.getCategory();
    }
    @GetMapping("/getOrderdata")
    public String getOrderdata(){
        return "product-service의 값들*****************"+service.getOrderData();
    }
}
