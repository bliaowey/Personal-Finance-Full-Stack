package com.example.financebackend.entity;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //primary key id for each unique record

    @Column(name = "account_type")
    private int accountType; //the type of account (see AccountType class)

    @Column(name = "date")
    private Date date; //the date the record was posted

    @Column(name = "value")
    private float value; //the value amount of money of the record

    @Column(name = "category_id")
    private int categoryId; //the id of the user-created category of which the record belongs to (see CategoryType class)

    @Column(name = "category_type")
    private int categoryType; //the category of the record (see CategoryType class

    @Column(name = "comments")
    private String comments; //user comments about the record
}
