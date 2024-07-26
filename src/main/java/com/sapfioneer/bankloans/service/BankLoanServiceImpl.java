package com.sapfioneer.bankloans.service;

import com.sapfioneer.bankloans.domain.*;
import com.sapfioneer.bankloans.dto.BankLoanDto;
import com.sapfioneer.bankloans.dto.LoanDetailsDto;
import com.sapfioneer.bankloans.dto.LoanRequestDto;
import com.sapfioneer.bankloans.dto.ProcedureStepDto;
import com.sapfioneer.bankloans.mapper.BankLoanMapper;
import com.sapfioneer.bankloans.repository.BankLoanRepository;
import com.sapfioneer.bankloans.repository.LoanRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BankLoanServiceImpl implements BankLoanService {

    private final BankLoanRepository bankLoanRepository;
    private final LoanRequestRepository loanRequestRepository;

    @Override
    public BankLoanDto createBankLoan(BankLoanDto bankLoanDto) {

        try {
            BankLoan newBankLoan = BankLoanMapper.toEntity(bankLoanDto);

            log.info("Saving new bank loan in db, request: {}", bankLoanDto);
            return BankLoanMapper.map(bankLoanRepository.save(newBankLoan));
        } catch (Exception e) {
            log.error("Error creating new bank loan: {}", e.getCause().getMessage());
            throw new RuntimeException("Error creating new bank loan: " + e.getCause().getMessage());
        }
    }

    @Override
    public BankLoanDto findBankLoanByName(String name) {
        BankLoan bankLoan = bankLoanRepository.findByName(name);
        if(bankLoan!=null) {
            return BankLoanMapper.map(bankLoan);
        }
        return new BankLoanDto();
    }


    @Override
    public LoanDetailsDto findLoanDetails(String bankLoanName) {
        BankLoan bl = bankLoanRepository.findByName(bankLoanName);
        LoanDetailsDto ld = new LoanDetailsDto();

        List<ProcedureStepDto> stepsList = new ArrayList<>();
        int totalDuration = 0;
        for(ProcedureStep ps: bl.getProcedureSteps()) {
            totalDuration+=ps.getDurationDays();
            stepsList.add(BankLoanMapper.map(ps));
        }
        ld.setDurationSum(totalDuration);
        ld.setSteps(stepsList);
   return ld;
    }
    public void deleteLoan(String name) {
        BankLoan bankLoan = bankLoanRepository.findByName(name);
        bankLoanRepository.delete(bankLoan);
    }

    @Override
    public BankLoanDto updateLoanName(String oldName, String newName) {
        BankLoan bankLoan = bankLoanRepository.findByName(oldName);
        bankLoan.setName(newName);
        bankLoanRepository.save(bankLoan);
        return BankLoanMapper.map(bankLoan);
    }

    @Override
    public LoanRequestDto createLoanRequest(LoanRequestDto loanRequestDto) {
        try {
        BankLoan bl = bankLoanRepository.findBankLoanById(loanRequestDto.getLoanTypeid());
        LoanRequest lr = BankLoanMapper.toEntity(loanRequestDto);

        List<LoanRequestWithProcedureStep> loanRequestWithProcedureStepList = new ArrayList<>();
        for(ProcedureStep ps: bl.getProcedureSteps()) {
            LoanRequestWithProcedureStep lrps = new LoanRequestWithProcedureStep();
            lrps.setProcedureStep(ps);
            loanRequestWithProcedureStepList.add(lrps);
        }
        lr.setLoanRequestSteps(loanRequestWithProcedureStepList);
        lr.setRequestStatus(RequestStatus.Processing);
        lr.setBankLoan(bl);

        log.info("Saving new loan request in db, request: {}", lr);
        return BankLoanMapper.map(loanRequestRepository.save(lr));
        } catch (Exception e) {
            log.error("Error creating new bank loan: {}", e.getCause().getMessage());
            throw new RuntimeException("Error creating new bank loan: " + e.getCause().getMessage());
        }
    }
}
