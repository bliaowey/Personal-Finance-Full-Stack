package com.example.financebackend.dto;

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
    private int accountType;
    private Date date;
    private float value;
    private int categoryId;
    private int categoryType;
    private String comments;
}
