package com.immigration.rcs.mvc.models.securiport;

import com.immigration.rcs.mvc.models.LogDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class SecLogDetails extends LogDetails {
    @OneToOne
    @JoinColumn(name = "sec_syslog_id")
    private SecLogEntity secLog;
}