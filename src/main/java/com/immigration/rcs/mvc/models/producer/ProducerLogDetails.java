package com.immigration.rcs.mvc.models.producer;

import com.immigration.rcs.mvc.models.LogDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProducerLogDetails extends LogDetails {
    @OneToOne
    @JoinColumn(name = "producer_log_id")
    private ProducerLogEntity producerLog;
}