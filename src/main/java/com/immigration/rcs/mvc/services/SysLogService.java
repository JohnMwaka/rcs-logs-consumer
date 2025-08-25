package com.immigration.rcs.mvc.services;

import com.google.gson.Gson;
import com.immigration.rcs.mvc.models.Enumerations;
import com.immigration.rcs.mvc.models.SysLog;
import com.immigration.rcs.mvc.services.api_gateway.ApiGatewayService;
import com.immigration.rcs.mvc.services.consumer.ConsumerService;
import com.immigration.rcs.mvc.services.producer.ProducerService;
import com.immigration.rcs.mvc.services.securiport.SecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysLogService {

    @Autowired
    private ApiGatewayService apiGatewayService;

    @Autowired
    private ProducerService producerService;

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private SecService secService;

    @Transactional
    public void save(SysLog sysLog) {
        try {
            if (sysLog.getSource().equals(Enumerations.Source.API)
                    || sysLog.getStatus().equals(Enumerations.Status.API_ERROR)
                    || sysLog.getStatus().equals(Enumerations.Status.KAFKA_ERROR)
            ) {
                apiGatewayService.save(sysLog);
                return;
            }
            if (sysLog.getStatus().equals(Enumerations.Status.QUEUED)) {
                apiGatewayService.save(sysLog);
            }
            if (!sysLog.getSource().equals(Enumerations.Source.RCS)) {
                switch (sysLog.getSource()) {
                    case BILL, BILL_REUSE, BILL_CANCELLATION, GEPG -> {
                        if (sysLog.getStatus().equals(Enumerations.Status.QUEUED)) {
                            producerService.save(sysLog);
                        } else {
                            consumerService.save(sysLog);
                        }
                    }
                }
            } else {
                secService.save(sysLog);
            }
        } catch (Exception e) {
            Gson gson = new Gson();
            System.out.println(gson.toJson(sysLog));
            System.out.println(e.getMessage());
        }
    }
}
