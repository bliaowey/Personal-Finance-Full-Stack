package com.example.financebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_types")
//AccountType is the object for the type of accounts the user creates (ex. bank account, credit card account, etc)
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //primary key id for each unique type

    @Column(name = "account_type")
    private String accountType; //the name of the account type (ex. "bank account", "credit card account")
}
