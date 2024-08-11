package com.example.financebackend.controller;

import com.example.financebackend.dto.AccountRecordDto;
import com.example.financebackend.service.AccountRecordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller for various HTTP requests for Account Records
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/account-records") //URL path to display all Account Records
public class AccountRecordController {

    private AccountRecordService accountRecordService;

    //Build Add Account Record REST API
    @PostMapping
    public ResponseEntity<AccountRecordDto> createAccountRecord(@RequestBody AccountRecordDto accountRecordDto) {
        AccountRecordDto savedAccRecord = accountRecordService.createAccountRecord(accountRecordDto);
        return new ResponseEntity<>(savedAccRecord, HttpStatus.CREATED);
    }

    //Build Get Account Record By ID REST API
    @GetMapping("{id}")
    public ResponseEntity<AccountRecordDto> getAccountRecordById(@PathVariable("id") int account_record_id) {
        AccountRecordDto accountRecordDto = accountRecordService.getAccountRecordById(account_record_id);
        return ResponseEntity.ok(accountRecordDto);
    }

    //Build Get All Account Records REST API
    @GetMapping
    public ResponseEntity<List<AccountRecordDto>> getAllAccountRecords() {
        List<AccountRecordDto> accountRecords = accountRecordService.getAllAccountRecords();
        return ResponseEntity.ok(accountRecords);
    }

    //Build Get Last 5 Account Records REST API vsd
    @GetMapping("/recent-transactions")
    public ResponseEntity<List<AccountRecordDto>> getLastFiveAccountRecords() {
        List<AccountRecordDto> accountRecords = accountRecordService.findLastFiveAccountRecords();
        return ResponseEntity.ok(accountRecords);
    }

    //Build Delete Account Record REST API this is a test change
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccountRecord(@PathVariable("id") int accountRecordId) {
        accountRecordService.deleteAccountRecord(accountRecordId);
        return ResponseEntity.ok("Account Record Deleted Successfully");
    }
}
