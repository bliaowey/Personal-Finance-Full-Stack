package com.example.financebackend.dto;

import com.example.financebackend.entity.AccountType;
import com.example.financebackend.entity.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//AccountRecordDto is the data transfer object that maps backend AccountRecord object to the database
public class AccountRecordDto {
    private int id;
    private AccountType accountType;
    private Date date;
    private float value;
    private CategoryType categoryType;
    private String comments;
}
