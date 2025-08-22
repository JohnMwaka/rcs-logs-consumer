package com.immigration.rcs.mvc.services.securiport;

import com.fasterxml.jackson.databind.JsonNode;
import com.immigration.rcs.mvc.models.SysLog;
import com.immigration.rcs.mvc.models.securiport.SecLogDetails;
import com.immigration.rcs.mvc.models.securiport.SecLogEntity;
import com.immigration.rcs.mvc.respositories.securiport.SecLogDetailsRepository;
import com.immigration.rcs.mvc.respositories.securiport.SecLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SecService {

    @Autowired
    private SecLogDetailsRepository logDetailsRepository;

    @Autowired
    private SecLogRepository logRepository;

    @Transactional
    public void save(SysLog sysLog) {
        SecLogEntity entity = new SecLogEntity();
        entity.setSourceId(sysLog.getSourceId());
        entity.setStatus(sysLog.getStatus());
        entity.setSource(sysLog.getSource());

        entity = logRepository.save(entity);

        SecLogDetails logDetails = new SecLogDetails();
        logDetails.setSecLog(entity);
        logDetails.setPayload(sysLog.getPayload());
        logDetails.setDescription(sysLog.getDescription());
        logDetailsRepository.save(logDetails);

    }

}
