package com.immigration.rcs.utils;

import lombok.Getter;

public class Enumerations {
    @Getter
    public enum Source {
        VISA("Visa"), SCREEN_LIST("Screening List"), PERMIT("Permit"), API("Api"), ENTRY_AND_EXIT("Entry & Exit");
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
