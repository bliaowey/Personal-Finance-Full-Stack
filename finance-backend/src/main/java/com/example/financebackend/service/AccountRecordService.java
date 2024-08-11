package com.example.financebackend.service;

import com.example.financebackend.dto.AccountRecordDto;
//import com.example.financebackend.respository.CategoryTypeRepository;

import java.util.List;

//Interface for AccountRecordService
public interface AccountRecordService {
    //Method for Adding an Account Record
    AccountRecordDto createAccountRecord(AccountRecordDto accountRecordDto);

    //Method for Getting an Account Record
    AccountRecordDto getAccountRecordById(int account_record_id);

    //Method for Getting all Account Records
    List<AccountRecordDto> getAllAccountRecords();

    List<AccountRecordDto> findLastFiveAccountRecords();
    //Method for Deleting an Account Record
    void deleteAccountRecord(int accountRecordId);
}
