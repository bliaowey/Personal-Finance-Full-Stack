package com.example.financebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category_types")
//CategoryType is the object for the specific budget categories for a posted record (ex. rent, food, travel, etc)
public class CategoryType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //primary key id for each unique category type

    @Column(name = "category_type")
    private String categoryType; //the name of the category type (ex. "rent", "food", "travel")
}
