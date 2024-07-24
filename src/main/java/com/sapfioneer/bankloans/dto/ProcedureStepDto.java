package com.sapfioneer.bankloans.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProcedureStepDto {
    private String name;
    private Integer orderNumber;
    private Integer durationDays;
}
