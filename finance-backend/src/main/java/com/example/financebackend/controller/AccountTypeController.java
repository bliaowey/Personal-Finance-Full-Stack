package com.example.financebackend.controller;

import com.example.financebackend.dto.AccountTypeDto;
import com.example.financebackend.service.AccountTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Controller for various HTTP requests for Account Types
@AllArgsConstructor
@RestController
@RequestMapping("/api/account-types") //URL path to display all Account Types
public class AccountTypeController {
    private AccountTypeService accountTypeService;

    //Build Add Account Type REST API
    @PostMapping
    public ResponseEntity<AccountTypeDto> createAccountType(@RequestBody AccountTypeDto accountTypeDto){
        AccountTypeDto savedAccType = accountTypeService.createAccountType(accountTypeDto);
        return new ResponseEntity<>(savedAccType, HttpStatus.CREATED);
    }

    //Build Get Account Type REST API
    @GetMapping("{id}")
    public ResponseEntity<AccountTypeDto> getAccountTypeById(@PathVariable("id") int account_type_id) {
        AccountTypeDto accountTypeDto = accountTypeService.getAccountTypeById(account_type_id);
        return ResponseEntity.ok(accountTypeDto);
    }
}
