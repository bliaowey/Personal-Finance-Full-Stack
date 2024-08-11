package com.example.financebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//CategoryDto is the data transfer object that maps backend CategoryType object to the database
public class CategoryTypeDto {
    private int id;
    private String categoryType;
}
