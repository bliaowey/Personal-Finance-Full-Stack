package com.example.financebackend.mapper;

import com.example.financebackend.dto.AccountRecordDto;
import com.example.financebackend.dto.AccountTypeDto;
import com.example.financebackend.dto.CategoryTypeDto;
import com.example.financebackend.entity.AccountRecord;
import com.example.financebackend.entity.AccountType;
import com.example.financebackend.entity.CategoryType;
import com.example.financebackend.respository.AccountTypeRepository;
import com.example.financebackend.respository.CategoryTypeRepository;

import java.util.List;

//EntityMapper is the class that maps the data from my backend entities to a Data Transfer Object and vice versa
public class EntityMapper {
    //Maps data from an AccountRecordDto object to an AccountRecord object
    public static AccountRecordDto mapToAccountRecordDto(AccountRecord accountRecord) {
        return new AccountRecordDto(
                accountRecord.getId(),
                accountRecord.getAccountType().getAccountType(),
                accountRecord.getDate(),
                accountRecord.getValue(),
                accountRecord.getCategoryType().getCategoryType(),
                accountRecord.getComments()
        );
    }

    static AccountTypeRepository accountTypeRepository;
    static CategoryTypeRepository categoryTypeRepository;
    //Maps data from an AccountRecord object to an AccountRecordDto object
    public static AccountRecord mapToAccountRecord(AccountRecordDto accountDto) {
        AccountRecord newAccountRecord = new AccountRecord();
        newAccountRecord.setValue(accountDto.getValue());
        newAccountRecord.setDate(accountDto.getDate());
        newAccountRecord.setComments(accountDto.getComments());

        List<AccountType> accountTypes = accountTypeRepository.findAll();
        accountTypes.forEach((type) -> {
            if (type.getAccountType() == accountDto.getAccountType()) {
                newAccountRecord.setAccountType(type);
            }
        });

        List<CategoryType> categoryTypes = categoryTypeRepository.findAll();
        categoryTypes.forEach((type) -> {
            if (type.getCategoryType() == accountDto.getCategoryType()) {
                newAccountRecord.setCategoryType(type);
            }
        });
        return newAccountRecord;
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
}
