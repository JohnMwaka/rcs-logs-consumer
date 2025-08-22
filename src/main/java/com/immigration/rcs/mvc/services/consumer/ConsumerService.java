package com.immigration.rcs.mvc.services.consumer;

import com.fasterxml.jackson.databind.JsonNode;
import com.immigration.rcs.mvc.models.SysLog;
import com.immigration.rcs.mvc.models.consumer.ConsumerLogDetails;
import com.immigration.rcs.mvc.models.consumer.ConsumerLogEntity;
import com.immigration.rcs.mvc.respositories.consumer.ConsumerLogDetailsRepository;
import com.immigration.rcs.mvc.respositories.consumer.ConsumerLogRepository;
import com.immigration.rcs.utils.JsonKeySearcher;
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
        Optional<JsonNode> PaymentControlNumber = JsonKeySearcher.findValueByKey(sysLog.getPayload(), "PaymentControlNumber");
        if (PaymentControlNumber.isPresent()) {
            entity.setControlNumber(PaymentControlNumber.get().asText());
        }

        Optional<JsonNode> ApplicationID = JsonKeySearcher.findValueByKey(sysLog.getPayload(), "ApplicationID");
        if (ApplicationID.isPresent()) {
            entity.setApplicationId(ApplicationID.get().asLong());
        } else {
            String appId = sysLog.getSourceId().replaceAll("[^0-9]", "");
            entity.setApplicationId(Long.parseLong(appId));
        }

        entity = logRepository.save(entity);

        ConsumerLogDetails logDetails = new ConsumerLogDetails();
        logDetails.setConsumerLog(entity);
        logDetails.setPayload(sysLog.getPayload());
        logDetails.setDescription(sysLog.getDescription());
        logDetailsRepository.save(logDetails);
    }

}
