package com.example.financebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//AccountTypeDto is the data transfer object that maps backend AccountType object to the database
public class AccountTypeDto {
    private int id;
    private String accountType;
}
