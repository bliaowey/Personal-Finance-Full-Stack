package com.example.financebackend.controller;

import com.example.financebackend.dto.AccountRecordDto;
import com.example.financebackend.entity.AccountRecord;
import com.example.financebackend.entity.AccountType;
import com.example.financebackend.entity.CategoryType;
import com.example.financebackend.mapper.EntityMapper;
import com.example.financebackend.respository.AccountTypeRepository;
import com.example.financebackend.respository.CategoryTypeRepository;
import com.example.financebackend.service.AccountRecordService;
import com.example.financebackend.service.AccountTypeService;
import com.example.financebackend.service.CategoryTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//Controller for various HTTP requests for Account Records
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/account-records") //URL path to display all Account Records
public class AccountRecordController {

    private AccountRecordService accountRecordService;

    @Autowired
    AccountTypeRepository accountTypeRepository;

    @Autowired
    CategoryTypeRepository categoryTypeRepository;

    //Build Add Account Record REST API
    @PostMapping
    public ResponseEntity<AccountRecordDto> createAccountRecord(@RequestParam("accountType") String accountType,
                                                                @RequestParam("date") String date,
                                                                @RequestParam("value") float value,
                                                                @RequestParam("categoryType") String categoryType,
                                                                @RequestParam("comments") String comments) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date1 = formatter.parse(date);

            AccountRecord newAccountRecord = new AccountRecord();
            newAccountRecord.setDate(date1);
            newAccountRecord.setValue(value);
            newAccountRecord.setComments(comments);

            List<AccountType> accountTypes = accountTypeRepository.findAll();
            accountTypes.forEach((type) -> {
                if (type.getAccountType() == accountType) {
                    newAccountRecord.setAccountType(type);
                } else {
                    AccountType newAccountType = new AccountType();
                    newAccountType.setAccountType(accountType);
                    accountTypeRepository.save(newAccountType);
                    newAccountRecord.setAccountType(newAccountType);
                }
            });

            List<CategoryType> categoryTypes = categoryTypeRepository.findAll();
            categoryTypes.forEach((type) -> {
                if (type.getCategoryType() == categoryType) {
                    newAccountRecord.setCategoryType(type);
                } else {
                    CategoryType newCategoryType = new CategoryType();
                    newCategoryType.setCategoryType(categoryType);
                    categoryTypeRepository.save(newCategoryType);
                    newAccountRecord.setCategoryType(newCategoryType);
                }
            });

            EntityMapper mapper = new EntityMapper();
            AccountRecordDto savedAccRecord = accountRecordService.createAccountRecord(mapper.mapToAccountRecordDto(newAccountRecord));
            return new ResponseEntity<>(savedAccRecord, HttpStatus.CREATED);
        } catch (ParseException e) {
            e.getMessage();
        }
        return null;
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
