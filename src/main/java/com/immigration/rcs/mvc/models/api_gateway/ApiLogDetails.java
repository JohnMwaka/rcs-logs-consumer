package com.immigration.rcs.mvc.models.api_gateway;

import com.immigration.rcs.mvc.models.LogDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ApiLogDetails extends LogDetails {
    @OneToOne
    @JoinColumn(name = "api_log_id")
    private ApiLogEntity apiLog;
}