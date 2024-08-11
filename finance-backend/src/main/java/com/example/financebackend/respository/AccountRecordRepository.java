package com.example.financebackend.respository;

import com.example.financebackend.entity.AccountRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface AccountRecordRepository extends JpaRepository<AccountRecord, Integer> {
    List<AccountRecord> findFirst5ByOrderByDateDesc();
}
