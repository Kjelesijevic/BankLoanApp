package com.sapfioneer.bankloans.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "loan_request")
public class LoanRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automatski inkrementuje id, 1, 2, itd.
    private Integer id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Double amount;
    @Column
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;
    @OneToOne
    @JoinColumn(name = "bank_loan_id")
    private BankLoan bankLoan;

    @OneToMany(cascade = CascadeType.ALL)//mapiranje jednog loan request-a sa vise steps-eva
    @JoinColumn(name = "loan_request_id")
    private List<LoanRequestWithProcedureStep> loanRequestSteps;

}
