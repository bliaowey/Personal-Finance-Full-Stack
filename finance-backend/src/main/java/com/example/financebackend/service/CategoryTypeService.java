package com.example.financebackend.service;

import com.example.financebackend.dto.CategoryTypeDto;

public interface CategoryTypeService {

    //Method for adding a Category Type
    CategoryTypeDto createCategoryType(CategoryTypeDto categoryTypeDto);

    //Method fore getting a Category Type
    CategoryTypeDto getCategoryTypeById(int category_type_id);
}
