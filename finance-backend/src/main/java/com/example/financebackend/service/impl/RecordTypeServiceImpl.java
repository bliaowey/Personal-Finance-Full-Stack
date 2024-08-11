package com.example.financebackend.service.impl;

import com.example.financebackend.dto.RecordTypeDto;
import com.example.financebackend.entity.RecordType;
import com.example.financebackend.exception.ResourceNotFoundException;
import com.example.financebackend.mapper.EntityMapper;
import com.example.financebackend.respository.RecordTypeRepository;
import com.example.financebackend.service.RecordTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

//Implementation for RecordTypeService
@Service
@AllArgsConstructor
public class RecordTypeServiceImpl implements RecordTypeService {
    private RecordTypeRepository recordTypeRepository;

    //Implementation of createRecordType
    @Override
    public RecordTypeDto createRecordType(RecordTypeDto recordTypeDto) {
        RecordType recordType = EntityMapper.mapToRecordType(recordTypeDto);
        RecordType savedRecordType = recordTypeRepository.save(recordType);
        return EntityMapper.mapToRecordTypeDto(savedRecordType);
    }

    @Override
    public RecordTypeDto getRecordTypeById(int record_type_id) {
        RecordType recordType = recordTypeRepository.findById(record_type_id).orElseThrow(() ->
                new ResourceNotFoundException("Record Type does not exist for the given id: " + record_type_id));
        return EntityMapper.mapToRecordTypeDto(recordType);
    }
}
