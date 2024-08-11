package com.example.financebackend.controller;

import com.example.financebackend.dto.CategoryTypeDto;
import com.example.financebackend.entity.CategoryType;
import com.example.financebackend.service.CategoryTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/category-types") //URL path to display all Category Types
public class CategoryTypeController {
    private CategoryTypeService categoryTypeService;

    //Build Add Category Type REST API
    @PostMapping
    public ResponseEntity<CategoryTypeDto> createCategoryType(@RequestBody CategoryTypeDto categoryTypeDto) {
        CategoryTypeDto savedCategoryType = categoryTypeService.createCategoryType(categoryTypeDto);
        return new ResponseEntity<>(savedCategoryType, HttpStatus.CREATED);
    }

    //Build Get Category Type REST API
    @GetMapping("{id}")
    public ResponseEntity<CategoryTypeDto> getCategoryTypeById(@PathVariable("id") int category_type_id) {
        CategoryTypeDto categoryTypeDto = categoryTypeService.getCategoryTypeById(category_type_id);
        return ResponseEntity.ok(categoryTypeDto);
    }
}
