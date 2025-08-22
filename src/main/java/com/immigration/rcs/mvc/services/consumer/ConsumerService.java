package com.immigration.rcs.mvc.services.consumer;

import com.fasterxml.jackson.databind.JsonNode;
import com.immigration.rcs.mvc.models.SysLog;
import com.immigration.rcs.mvc.models.consumer.ConsumerLogDetails;
import com.immigration.rcs.mvc.models.consumer.ConsumerLogEntity;
import com.immigration.rcs.mvc.respositories.consumer.ConsumerLogDetailsRepository;
import com.immigration.rcs.mvc.respositories.consumer.ConsumerLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ConsumerService {

    @Autowired
    private ConsumerLogDetailsRepository logDetailsRepository;

    @Autowired
    private ConsumerLogRepository logRepository;

    @Transactional
    public void save(SysLog sysLog) {
        ConsumerLogEntity entity = new ConsumerLogEntity();
        entity.setSourceId(sysLog.getSourceId());
        entity.setStatus(sysLog.getStatus());
        entity.setSource(sysLog.getSource());

        entity = logRepository.save(entity);

        ConsumerLogDetails logDetails = new ConsumerLogDetails();
        logDetails.setConsumerLog(entity);
        logDetails.setPayload(sysLog.getPayload());
        logDetails.setDescription(sysLog.getDescription());
        logDetailsRepository.save(logDetails);
    }

}
