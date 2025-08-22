package com.immigration.rcs.mvc.services.api_gateway;

import com.immigration.rcs.mvc.models.SysLog;
import com.immigration.rcs.mvc.models.api_gateway.ApiLogDetails;
import com.immigration.rcs.mvc.models.api_gateway.ApiLogEntity;
import com.immigration.rcs.mvc.respositories.api_gateway.ApiLogDetailsRepository;
import com.immigration.rcs.mvc.respositories.api_gateway.ApiLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApiGatewayService {

    @Autowired
    private ApiLogDetailsRepository logDetailsRepository;

    @Autowired
    private ApiLogRepository logRepository;

    @Transactional
    public void save(SysLog sysLog) {
        ApiLogEntity entity = new ApiLogEntity();
        entity.setSourceId(sysLog.getSourceId());
        entity.setStatus(sysLog.getStatus());
        entity.setSource(sysLog.getSource());

        entity = logRepository.save(entity);

        ApiLogDetails logDetails = new ApiLogDetails();
        logDetails.setApiLog(entity);
        logDetails.setPayload(sysLog.getPayload());
        logDetails.setDescription(sysLog.getDescription());
        logDetailsRepository.save(logDetails);
    }

}
