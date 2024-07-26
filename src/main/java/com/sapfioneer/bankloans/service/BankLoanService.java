package com.sapfioneer.bankloans.service;

import com.sapfioneer.bankloans.dto.BankLoanDto;
import com.sapfioneer.bankloans.dto.LoanDetailsDto;
import com.sapfioneer.bankloans.dto.LoanRequestDto;

public interface BankLoanService {

    BankLoanDto createBankLoan(BankLoanDto bankLoanDto);

    BankLoanDto findBankLoanByName(String name);

    LoanDetailsDto findLoanDetails(String bankLoanName);
    void deleteLoan(String name);

    BankLoanDto updateLoanName(String oldName, String name);

    LoanRequestDto createLoanRequest(LoanRequestDto loanRequestDto);
}
