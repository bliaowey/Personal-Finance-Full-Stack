package com.example.financebackend;

import com.example.financebackend.service.FileStorageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class FinanceBackendApplication implements CommandLineRunner{
	@Resource
	FileStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(FinanceBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		storageService.init();
	}
}
