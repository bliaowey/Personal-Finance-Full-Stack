package com.example.financebackend.service;

import com.example.financebackend.dto.AccountTypeDto;

//Interface for AccountTypeService
public interface AccountTypeService {

    //Method for Adding an Account Type
    AccountTypeDto createAccountType(AccountTypeDto accountTypeDto);

    //Method for Getting an Account Type
    AccountTypeDto getAccountTypeById(int account_type_id);
}
