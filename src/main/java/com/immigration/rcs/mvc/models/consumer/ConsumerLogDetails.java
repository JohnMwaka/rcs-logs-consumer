package com.immigration.rcs.mvc.models.consumer;

import com.immigration.rcs.mvc.models.LogDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class ConsumerLogDetails extends LogDetails {
    @OneToOne
    @JoinColumn(name = "consumer_log_id")
    private ConsumerLogEntity consumerLog;
}