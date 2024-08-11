package com.example.financebackend.respository;

import com.example.financebackend.entity.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordTypeRepository extends JpaRepository<RecordType, Integer> {
}
