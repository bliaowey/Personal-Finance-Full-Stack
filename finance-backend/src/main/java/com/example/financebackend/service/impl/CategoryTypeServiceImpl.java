package com.example.financebackend.service.impl;

import com.example.financebackend.dto.CategoryTypeDto;
import com.example.financebackend.entity.CategoryType;
import com.example.financebackend.exception.ResourceNotFoundException;
import com.example.financebackend.mapper.EntityMapper;
import com.example.financebackend.respository.CategoryTypeRepository;
import com.example.financebackend.service.CategoryTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

//Implementation for CategoryTypeService
@Service
@AllArgsConstructor
public class CategoryTypeServiceImpl implements CategoryTypeService {
    private CategoryTypeRepository categoryTypeRepository;

    //Implementation of CreateCategoryType
    @Override
    public CategoryTypeDto createCategoryType(CategoryTypeDto categoryTypeDto) {
        CategoryType categoryType = EntityMapper.mapToCategoryType(categoryTypeDto);
        CategoryType savedCategoryType = categoryTypeRepository.save(categoryType);
        return EntityMapper.mapToCategoryTypeDto(savedCategoryType);
    }

    @Override
    public CategoryTypeDto getCategoryTypeById(int category_type_id) {
        CategoryType categoryType = categoryTypeRepository.findById(category_type_id).orElseThrow(() ->
                new ResourceNotFoundException("Category Type does not exist for the given id: " + category_type_id));
        return EntityMapper.mapToCategoryTypeDto(categoryType);
    }
}
