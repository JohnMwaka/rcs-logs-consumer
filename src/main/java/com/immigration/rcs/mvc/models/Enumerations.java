package com.immigration.rcs.mvc.models;

import lombok.Getter;

public class Enumerations {

    @Getter
    public enum Source {
        API("API"), API_CALLBACK("API Callback"), BILL("New Bill"), BILL_REUSE("Bill Reuse"), BILL_CANCELLATION("Bill Cancellation"), RECONCILIATION("Reconciliation"), BILL_CHANGE("Bill Change"), PAYMENT("GePG Payment"), RCS_BILLS("RCS Bills System"),
        RCS_CONTROL_NUMBERS("RCS Control Numbers System"),
        RCS_PAYMENTS("RCS Payments System"),
        ;
        private final String value;

        Source(String value) {
            this.value = value;
        }
    }

    @Getter
    public enum Status {
        QUEUED("Queued"), KAFKA_ERROR("Kafka error"), API_ERROR("Api error"), SUCCESS("Success"), FAILED("Failed");
        private final String value;

        Status(String value) {
            this.value = value;
        }
    }
}
