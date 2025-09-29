package com.immigration.rcs.mvc.models;

import lombok.Getter;

public class Enumerations {

    @Getter
    public enum Source {
        API("API"), API_CALLBACK("API Callback"), BILL("New Bill"), BILL_REUSE("Bill Reuse"), BILL_CANCELLATION("Bill Cancellation"), RECONCILIATION("Reconciliation"), BILL_CHANGE("Bill Change"), PAYMENT("GePG Payment"), RCS_BILLS("RCS Bills System"), BILL_CALLBACK("Bill Callback"), RECONCILIATION_CALLBACK("Reconciliation Callback"),
        RCS_CONTROL_NUMBERS("RCS Control Numbers System"),
        RCS_PAYMENTS("RCS Payments System"),
        RCS_BILL_CALLBACK("New Bill"), RCS_BILL_REUSE_CALLBACK("Bill Reuse"), RCS_BILL_CANCELLATION_CALLBACK("Bill Cancellation"), RCS_BILL_CHANGE_CALLBACK("Bill Change");
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
