package com.example.financebackend.service.impl;

import com.example.financebackend.dto.AccountTypeDto;
import com.example.financebackend.entity.AccountType;
import com.example.financebackend.exception.ResourceNotFoundException;
import com.example.financebackend.mapper.EntityMapper;
import com.example.financebackend.respository.AccountTypeRepository;
import com.example.financebackend.service.AccountTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

//Implementation for AccountTypeService
@Service
@AllArgsConstructor
public class AccountTypeServiceImpl implements AccountTypeService {
    private AccountTypeRepository accountTypeRepository;

    //Implementation of CreateAccountType
    @Override
    public AccountTypeDto createAccountType(AccountTypeDto accountTypeDto) {
        AccountType accountType = EntityMapper.mapToAccountType(accountTypeDto);
        AccountType savedAccType = accountTypeRepository.save(accountType);
        return EntityMapper.mapToAccountTypeDto(savedAccType);
    }

    @Override
    public AccountTypeDto getAccountTypeById(int account_type_id) {
        AccountType accountType = accountTypeRepository.findById(account_type_id).orElseThrow(() ->
                new ResourceNotFoundException("Account Type does not exist for given id: " + account_type_id));
        return EntityMapper.mapToAccountTypeDto(accountType);
    }
}
