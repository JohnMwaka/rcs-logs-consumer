package com.immigration.rcs.kafka;

import com.google.gson.Gson;
import com.immigration.rcs.mvc.models.SysLog;
import com.immigration.rcs.mvc.services.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.immigration.rcs.kafka.KafkaConstants.RCS;
import static com.immigration.rcs.kafka.KafkaConstants.SYS_LOGS_TOPIC;

@Component
public class KafkaConsumerService {
    private final Gson gson = new Gson();

    @Autowired
    private SysLogService sysLogService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @KafkaListener(topics = SYS_LOGS_TOPIC, groupId = RCS)
    public void consumeSysLogs(@Payload String payload, Acknowledgment acknowledgment) {
        SysLog sysLog = gson.fromJson(payload, SysLog.class);
        System.out.println(sysLog.getSourceId());
        System.out.println(sysLog.getSource());
        sysLogService.save(sysLog);
        acknowledgment.acknowledge();
    }
}