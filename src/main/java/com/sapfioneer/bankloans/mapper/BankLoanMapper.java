package com.sapfioneer.bankloans.mapper;

import com.sapfioneer.bankloans.domain.BankLoan;
import com.sapfioneer.bankloans.domain.LoanRequest;
import com.sapfioneer.bankloans.domain.LoanRequestWithProcedureStep;
import com.sapfioneer.bankloans.domain.ProcedureStep;
import com.sapfioneer.bankloans.dto.BankLoanDto;
import com.sapfioneer.bankloans.dto.LoanRequestDto;
import com.sapfioneer.bankloans.dto.ProcedureStepDto;

import java.util.ArrayList;
import java.util.List;

public class BankLoanMapper {

    public static BankLoanDto map(BankLoan bankLoan) {

        List<ProcedureStepDto> procedureSteps = new ArrayList<>();
        for (ProcedureStep ps : bankLoan.getProcedureSteps()) {
            procedureSteps.add(map(ps));
        }
        return BankLoanDto.builder()
                .name(bankLoan.getName())
                .procedureSteps(procedureSteps)
                .build();
    }

    public static BankLoan toEntity(BankLoanDto bankLoanDto) {
        List<ProcedureStep> procedureSteps = new ArrayList<>();

        for (ProcedureStepDto psDto : bankLoanDto.getProcedureSteps()) {
            procedureSteps.add(toEntity(psDto));
        }
        return BankLoan.builder()
                .name(bankLoanDto.getName())
                .procedureSteps(procedureSteps)
                .build();
    }

    public static ProcedureStepDto map(ProcedureStep procedureStep) {
        return ProcedureStepDto.builder()
                .name(procedureStep.getName())
                .orderNumber(procedureStep.getOrderNumber())
                .durationDays(procedureStep.getDurationDays())
                .build();
    }

    public static ProcedureStep toEntity(ProcedureStepDto procedureStepDto) {
        return ProcedureStep.builder()
                .name(procedureStepDto.getName())
                .orderNumber(procedureStepDto.getOrderNumber())
                .durationDays(procedureStepDto.getDurationDays())
                .build();
    }

    public static LoanRequest toEntity(LoanRequestDto loanRequestDto) {

        return LoanRequest.builder()
                .firstName(loanRequestDto.getFirstName())
                .lastName(loanRequestDto.getLastName())
                .amount(loanRequestDto.getAmount())
                .build();
    }

    public static LoanRequestDto map(LoanRequest loanRequest) {
        return LoanRequestDto.builder()
                .firstName(loanRequest.getFirstName())
                .lastName(loanRequest.getLastName())
                .amount(loanRequest.getAmount())
                .loanTypeid(loanRequest.getId())
                .build();
    }

}
