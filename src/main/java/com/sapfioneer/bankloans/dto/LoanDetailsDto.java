package com.sapfioneer.bankloans.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanDetailsDto {
    private Integer durationSum;
    private List<ProcedureStepDto> steps;
}
