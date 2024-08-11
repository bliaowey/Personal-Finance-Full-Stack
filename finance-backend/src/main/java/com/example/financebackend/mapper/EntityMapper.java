package com.example.financebackend.mapper;

import com.example.financebackend.dto.AccountRecordDto;
import com.example.financebackend.dto.AccountTypeDto;
import com.example.financebackend.dto.CategoryTypeDto;
import com.example.financebackend.dto.RecordTypeDto;
import com.example.financebackend.entity.AccountRecord;
import com.example.financebackend.entity.AccountType;
import com.example.financebackend.entity.CategoryType;
import com.example.financebackend.entity.RecordType;

//EntityMapper is the class that maps the data from my backend entities to a Data Transfer Object and vice versa
public class EntityMapper {
    //Maps data from an AccountRecordDto object to an AccountRecord object
    public static AccountRecordDto mapToAccountRecordDto(AccountRecord accountRecord) {
        return new AccountRecordDto(
                accountRecord.getId(),
                accountRecord.getAccountType(),
                accountRecord.getDate(),
                accountRecord.getValue(),
                accountRecord.getCategoryId(),
                accountRecord.getCategoryType(),
                accountRecord.getComments()
        );
    }

    //Maps data from an AccountRecord object to an AccountRecordDto object
    public static AccountRecord mapToAccountRecord(AccountRecordDto accountDto) {
        return new AccountRecord(
                accountDto.getId(),
                accountDto.getAccountType(),
                accountDto.getDate(),
                accountDto.getValue(),
                accountDto.getCategoryId(),
                accountDto.getCategoryType(),
                accountDto.getComments()
        );
    }

    //Maps data from an AccountType object to an AccountTypeDto object
    public static AccountTypeDto mapToAccountTypeDto(AccountType accountType) {
        return new AccountTypeDto(
                accountType.getId(),
                accountType.getAccountType()
        );
    }

    //Maps data from an AccountTypeDto object to an AccountType object
    public static AccountType mapToAccountType(AccountTypeDto accountTypeDto) {
        return new AccountType(
                accountTypeDto.getId(),
                accountTypeDto.getAccountType()
        );
    }

    //Maps data from an CategoryType object to an CategoryTypeDto object
    public static CategoryTypeDto mapToCategoryTypeDto(CategoryType categoryType) {
        return new CategoryTypeDto(
                categoryType.getId(),
                categoryType.getCategoryType()
        );
    }

    //Maps data from an CategoryTypeDto object to an CategoryType object
    public static CategoryType mapToCategoryType(CategoryTypeDto categoryTypeDto) {
        return new CategoryType(
                categoryTypeDto.getId(),
                categoryTypeDto.getCategoryType()
        );
    }

    //Maps data from an RecordType object to an RecordTypeDto object
    public static RecordTypeDto mapToRecordTypeDto(RecordType recordType) {
        return new RecordTypeDto(
                recordType.getId(),
                recordType.getCategory()
        );
    }

    //Maps data from an RecordTypeDto object to an RecordType object
    public static RecordType mapToRecordType(RecordTypeDto recordTypeDto) {
        return new RecordType(
                recordTypeDto.getId(),
                recordTypeDto.getRecordType()
        );
    }
}
