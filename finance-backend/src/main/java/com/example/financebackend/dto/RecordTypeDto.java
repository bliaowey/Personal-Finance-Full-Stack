package com.example.financebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//RecordTypeDto is the data transfer object that maps backend RecordType object to the database
public class RecordTypeDto {
    private int id;
    private String recordType;
}
