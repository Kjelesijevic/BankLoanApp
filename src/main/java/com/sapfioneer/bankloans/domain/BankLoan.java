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
@Table(name = "bank_loan")
public class BankLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automatski inkrementuje id, 1, 2, itd.
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name;
    @OneToMany(cascade = CascadeType.ALL)//mapiranje jednog loan-a sa vise steps-eva
    @JoinColumn(name = "bank_loan_id")
    private List<ProcedureStep> procedureSteps;

}
