package com.sapfioneer.bankloans.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "loan_request_with_procedure_step")
public class LoanRequestWithProcedureStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    ProcedureStepStatus stepStatus;

    @OneToOne
    @JoinColumn(name = "procedure_step_id")
    ProcedureStep procedureStep;

    @PrePersist //pre spustanja u bazu, odradi ovu metodu
    private void addStatus(){
        stepStatus = ProcedureStepStatus.Pending;
    }

}
