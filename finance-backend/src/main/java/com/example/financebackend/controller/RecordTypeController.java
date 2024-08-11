package com.example.financebackend.controller;

import com.example.financebackend.dto.RecordTypeDto;
import com.example.financebackend.service.RecordTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/record-types") //URL path to display all Record Types
public class RecordTypeController {
    private RecordTypeService recordTypeService;

    //Build Add Record Type REST API
    @PostMapping
    public ResponseEntity<RecordTypeDto> createRecordType(@RequestBody RecordTypeDto recordTypeDto) {
        RecordTypeDto savedRecordType = recordTypeService.createRecordType(recordTypeDto);
        return new ResponseEntity<>(savedRecordType, HttpStatus.CREATED);
    }

    //Build Get Record Type REST API
    @GetMapping("{id}")
    public ResponseEntity<RecordTypeDto> getRecordTypeById(@PathVariable("id") int record_type_id) {
        RecordTypeDto recordTypeDto = recordTypeService.getRecordTypeById(record_type_id);
        return ResponseEntity.ok(recordTypeDto);
    }
}
