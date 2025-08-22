package com.immigration.rcs.mvc.models;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SysLog {
    private String sourceId;
    private Enumerations.Source source;
    private Enumerations.Status status;
    private String payload;
    private String description;
}
