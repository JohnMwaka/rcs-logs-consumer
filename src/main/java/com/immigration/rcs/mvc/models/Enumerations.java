package com.immigration.rcs.mvc.models;

import lombok.Getter;

public class Enumerations {

    @Getter
    public enum Source {
        API("API"), BILL("New Bill"), GEPG("GePG"), RCS("RCS System");
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
