package com.example.financebackend.respository;

import com.example.financebackend.entity.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryTypeRepository extends JpaRepository<CategoryType, Integer> {
}
