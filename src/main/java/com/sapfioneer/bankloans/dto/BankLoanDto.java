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
public class BankLoanDto { //data transfer object - klasa koja predstavlja json koji radi
    // transfer podataka sa fronta

    private String name;
    private List<ProcedureStepDto> procedureSteps;

}
