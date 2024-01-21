package com.cba.mpos.aoer.controller;

import com.cba.mpos.aoer.model.external.TargetEntity;
import com.cba.mpos.aoer.model.internal.SourceEntity;
import com.cba.mpos.aoer.service.DataTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
//@RequestMapping("/transfer")
@RequiredArgsConstructor
public class DataTransferController {

    private final DataTransferService dataTransferService;
    private final RestTemplate restTemplate;

    @PostConstruct
    @Scheduled(fixedDelay = 1000)
    public void transferData() {
        List<TargetEntity> dataToTransfer = dataTransferService.transferData();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        if(dataToTransfer!=null && dataToTransfer.size()>0)
        for (TargetEntity target : dataToTransfer) {
//            send target entity one after the another
            HttpEntity<TargetEntity> entity = new HttpEntity<>(target,headers);
            ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:9093/transfer", entity, String.class);
            System.out.println(stringResponseEntity.getStatusCode());
        }
        System.out.println("Data Transferred every 10s");
    }
//
//    @PostConstruct
//    @Scheduled(fixedDelay = 10000)
//    public void transferData() {
//        List<TargetEntity> dataToTransfer = dataTransferService.transferData();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        for (TargetEntity target : dataToTransfer) {
//            HttpEntity<List<TargetEntity>> requestEntity = new HttpEntity<>(dataToTransfer, headers);
//            ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:9090/transfer", requestEntity, String.class);
//        }
//
//
//
//        System.out.println("Data Transferred every 10s");
//    }

    /*
    @PostMapping("/transfer")
    public ResponseEntity<String> transferData() {

        dataTransferService.transferData();
        return ResponseEntity.ok("Data transfer successful");
    }

    @GetMapping("/target/getAll")
    public ResponseEntity<List<TargetEntity>> getAllTarget() {

        List<TargetEntity> targetData = dataTransferService.getAllTargetData();
        return new ResponseEntity<>(targetData, HttpStatus.OK);
    }

    @GetMapping("/source/getAll")
    public ResponseEntity<List<SourceEntity>> getAllSource() {

        List<SourceEntity> targetData = dataTransferService.getAllSourceData();
        return new ResponseEntity<>(targetData, HttpStatus.OK);
    }
     */
}
