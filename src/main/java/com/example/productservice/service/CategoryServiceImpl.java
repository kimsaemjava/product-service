package com.example.productservice.service;

import com.example.productservice.client.OrderServiceClient;
import com.example.productservice.dao.CategoryDAO;
import com.example.productservice.dto.CategoryRequest;
import com.example.productservice.dto.CategoryResponse;
import com.example.productservice.entity.Category;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryDAO dao;
//    private final OrderServiceClient orderServiceClient;
    @Override
    public void write(CategoryRequest category) {
        //CategoryRequest -> Entity
        ModelMapper mapper = new ModelMapper();
        Category categoryEntity = mapper.map(category,Category.class);
        dao.write(categoryEntity);
    }

    @Override
    public List<CategoryResponse> getCategory() {
        List<Category> categoryList = dao.getCategory();
        List<CategoryResponse> categoryResponseList = new ArrayList<>();
        for(Category category : categoryList){
            CategoryResponse response =
                    new CategoryResponse(category.getCategoryId(),
                            category.getCategoryName(),
                            category.getInfo());
            categoryResponseList.add(response);
        }

        return categoryResponseList;
    }

    @Override
    public String getOrderData() {
        String result ="";
        try{
//            result = orderServiceClient.getOrderTest();
        }catch(FeignException e){
            log.error(e.getMessage());
            result = "다시 시도 하세요...지금은 확인할 수 없습니다.";
        }

        return result;
    }
}
