package com.example.financebackend.controller;

import java.awt.desktop.SystemSleepEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import com.example.financebackend.dto.AccountRecordDto;
import com.example.financebackend.entity.AccountRecord;
import com.example.financebackend.entity.FileInfo;
import com.example.financebackend.mapper.EntityMapper;
import com.example.financebackend.message.ResponseMessage;
import com.example.financebackend.service.AccountRecordService;
import com.example.financebackend.service.FileStorageService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@AllArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/file")
public class FilesController {
    @Autowired
    private FileStorageService storageService;
    private AccountRecordController accountController;

    private void handleLine(String s) {
        String[] accountRecords = s.split("\n");

        for (int i = 0; i < accountRecords.length; i ++) {
            String[] accountRecord = accountRecords[i].split(",");
            if (accountRecord.length > 6) {
                throw new RuntimeException("Too many columns in the file!");
            }

            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date date = formatter.parse(accountRecord[1]);
                AccountRecord newAccountRecord = new AccountRecord(
                        Integer.parseInt(accountRecord[0]), //Account Type
                        date, //Date
                        Float.parseFloat(accountRecord[2]), //Value
                        Integer.parseInt(accountRecord[3]), //Category ID
                        Integer.parseInt(accountRecord[4]), //Category Type
                        accountRecord[5] //Comments
                );
                AccountRecordDto dto = EntityMapper.mapToAccountRecordDto(newAccountRecord);
                accountController.createAccountRecord(dto);
            } catch (ParseException e) {
                e.getMessage();
            }
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            InputStream inputStream = file.getInputStream();
            new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().forEach(this::handleLine);

            message = "Uploaded the file successfully: "+ file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }
        catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/get-files")
    public ResponseEntity<List<FileInfo>> getAllFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String fileName = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString())
                    .build().toString();
            return new FileInfo(fileName, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/get-files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) {
        Resource file = storageService.load(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
