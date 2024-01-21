package com.example.demo.controller;

import com.example.demo.model.TargetEntity;
import com.example.demo.service.DataTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class DataTransferController {

    private final DataTransferService dataTransferService;

    @PostMapping("/transfer")
    public void saveAllTarget(@RequestBody TargetEntity dataToSave) {
        String save = dataTransferService.save(dataToSave);
        System.out.println(save);
    }
}
