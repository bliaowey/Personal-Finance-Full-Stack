package com.example.financebackend.service;

import com.example.financebackend.dto.RecordTypeDto;

public interface RecordTypeService {

    //Method for Adding a Record Type
    RecordTypeDto createRecordType(RecordTypeDto recordTypeDto);

    //Method for Getting a Record Type
    RecordTypeDto getRecordTypeById(int record_type_id);
}
