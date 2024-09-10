package com.example.financebackend.entity;

import com.example.financebackend.dto.AccountRecordDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_records")
//AccountRecord is the object for a single record posted to an account
public class AccountRecord {
    public AccountRecord(String accountType,
                         Date date,
                         float value,
                         String categoryType,
                         String comments
                         ){
        this.date = date;
        this.value = value;
        this.comments = comments;

        AccountType type = new AccountType(accountType);
        this.accountType = type;

        CategoryType category = new CategoryType(categoryType);
        this.categoryType = category;
    };
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //primary key id for each unique record

    @ManyToOne
    @JoinColumn(name = "account_type_id", referencedColumnName = "id")
    private AccountType accountType;

    @Column(name = "date")
    private Date date; //the date the record was posted

    @Column(name = "value")
    private float value; //the value amount of money of the record

    @ManyToOne
    @JoinColumn(name = "category_type", referencedColumnName = "id")
    private CategoryType categoryType; //the id of the user-created category of which the record belongs to (see CategoryType class)

    @Column(name = "comments")
    private String comments; //user comments about the record
}
