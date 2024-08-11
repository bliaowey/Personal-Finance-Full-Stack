package com.example.financebackend.service.impl;

import com.example.financebackend.dto.AccountRecordDto;
import com.example.financebackend.entity.AccountRecord;
import com.example.financebackend.exception.ResourceNotFoundException;
import com.example.financebackend.mapper.EntityMapper;
import com.example.financebackend.respository.AccountRecordRepository;
import com.example.financebackend.service.AccountRecordService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

//Implementation for AccountRecordService interface
@Service
@AllArgsConstructor
public class AccountRecordServiceImpl implements AccountRecordService {
    private AccountRecordRepository accountRecordRepository;

    //Implementation for createAccountRecord
    @Override
    public AccountRecordDto createAccountRecord(AccountRecordDto accountRecordDto) {
        AccountRecord accountRecord = EntityMapper.mapToAccountRecord(accountRecordDto);
        AccountRecord savedAccRecord = accountRecordRepository.save(accountRecord);
        return EntityMapper.mapToAccountRecordDto(savedAccRecord);
    }

    //Implementation of getAccountRecordById
    @Override
    public AccountRecordDto getAccountRecordById(int account_record_id) {
        AccountRecord accountRecord = accountRecordRepository.findById(account_record_id).orElseThrow(()
                -> new ResourceNotFoundException("Account Record does not exist with given id: " + account_record_id));
        return EntityMapper.mapToAccountRecordDto(accountRecord);
    }

    //Implementation of getAllAccountRecords
    @Override
    public List<AccountRecordDto> getAllAccountRecords() {
        List<AccountRecord> accountRecords = accountRecordRepository.findAll();
        return accountRecords.stream().map((accountRecord) -> EntityMapper.mapToAccountRecordDto(accountRecord))
                .collect(Collectors.toList());
    }

    @Override
    public List<AccountRecordDto> findLastFiveAccountRecords() {
        List<AccountRecord> accountRecords = accountRecordRepository.findFirst5ByOrderByDateDesc();
        return accountRecords.stream().map((accountRecord) -> EntityMapper.mapToAccountRecordDto(accountRecord))
                .collect(Collectors.toList());
    }

    //Implementation of deleteAccountRecord
    @Override
    public void deleteAccountRecord(int accountRecordId) {
        AccountRecord accountRecord = accountRecordRepository.findById(accountRecordId).orElseThrow(
                () -> new ResourceNotFoundException("Account Record does not exist for given ID: " + accountRecordId)
        );
        accountRecordRepository.deleteById(accountRecordId);
    }

}
