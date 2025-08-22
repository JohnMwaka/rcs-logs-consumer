package com.immigration.rcs.mvc.services.producer;

import com.fasterxml.jackson.databind.JsonNode;
import com.immigration.rcs.mvc.models.SysLog;
import com.immigration.rcs.mvc.models.producer.ProducerLogDetails;
import com.immigration.rcs.mvc.models.producer.ProducerLogEntity;
import com.immigration.rcs.mvc.respositories.producer.ProducerLogDetailsRepository;
import com.immigration.rcs.mvc.respositories.producer.ProducerLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProducerService {

    @Autowired
    private ProducerLogDetailsRepository logDetailsRepository;

    @Autowired
    private ProducerLogRepository logRepository;

    @Transactional
    public void save(SysLog sysLog) {
        ProducerLogEntity entity = new ProducerLogEntity();
        entity.setSourceId(sysLog.getSourceId());
        entity.setStatus(sysLog.getStatus());
        entity.setSource(sysLog.getSource());

        entity = logRepository.save(entity);

        ProducerLogDetails logDetails = new ProducerLogDetails();
        logDetails.setProducerLog(entity);
        logDetails.setPayload(sysLog.getPayload());
        logDetails.setDescription(sysLog.getDescription());
        logDetailsRepository.save(logDetails);
    }

}
