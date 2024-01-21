package com.example.demo.service;

import com.example.demo.model.TargetEntity;
import com.example.demo.repository.TargetRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataTransferService {

    private final TargetRepository targetRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(DataTransferService.class);

    public String save(TargetEntity dataToTransfer) {
        if (dataToTransfer != null ) {
            if(dataToTransfer!=null) {
                targetRepository.save(dataToTransfer);
            }
        }
            return "Successfully saved";
    }
//
//    private List<TargetEntity> convertToDestinationEntity(List<SourceEntity> sourceData) {
//        if (sourceData == null || sourceData.isEmpty()) {
//            LOGGER.info("No source data available for conversion");
//            return null;
//        }
//
//        List<TargetEntity> tt = new ArrayList<>();
//        for (SourceEntity tr:sourceData) {
//            TargetEntity targetEntity = mapSourceToTarget(tr);
//            if(targetEntity!=null){
//                tt.add(targetEntity);
//            }
//        }
//        return tt;
//    }
//
//    TargetEntity mapSourceToTarget(SourceEntity sourceEntity) {
//
//        TargetEntity targetEntity = new TargetEntity();
//        LocalDateTime localDateTime = sourceEntity.getLogDateTime().toLocalDateTime();
//        System.out.println("SourceEntity before save: " + sourceEntity);
//        if (sourceEntity.getIsProcessed() == false) {
//            targetEntity.setDate(localDateTime.toLocalDate());
//            targetEntity.setTime(localDateTime.toLocalTime());
//            targetEntity.setEmployee_id(sourceEntity.getEmpID());
//            targetEntity.setAction(String.valueOf(1));
//            targetEntity.setAction_hbx(String.valueOf(0));
//            targetEntity.setCheck(String.valueOf(0));
//            targetEntity.setStatus(String.valueOf(sourceEntity.getIsProcessed()));
//
//            // After pushing the data, IsProcessed should be updated
//            try {
//                Optional<CheckInOut> checkInOutOptional = checkInOutRepository.findById((int) sourceEntity.getLogID());
//
//                if (checkInOutOptional.isPresent()) {
//                    CheckInOut checkInOut = checkInOutOptional.get();
//                    checkInOut.setIsProcessed((byte) 1);
//                    checkInOutRepository.save(checkInOut);
//
//                } else {
//                    throw new IllegalStateException("CheckInOut record not found for LogID: " + sourceEntity.getLogID());
//                }
//            } catch (Exception e) {
//                LOGGER.error("Error updating CheckInOut record for LogID: " + sourceEntity.getLogID(), e);
//                throw new RuntimeException("Error updating CheckInOut record");
//            }
//            System.out.println("SourceEntity after save: " + sourceEntity);
//            return targetEntity;
//        }
//        else{
//            return null;
//        }
//
}
