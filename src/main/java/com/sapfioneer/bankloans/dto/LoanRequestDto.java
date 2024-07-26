package com.sapfioneer.bankloans.dto;

import com.sapfioneer.bankloans.domain.BankLoan;
import com.sapfioneer.bankloans.domain.RequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequestDto {

    private String firstName;
    private String lastName;
    private Double amount;
    private Integer loanTypeid;

}
