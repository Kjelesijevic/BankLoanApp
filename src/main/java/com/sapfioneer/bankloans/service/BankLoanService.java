package com.sapfioneer.bankloans.service;

import com.sapfioneer.bankloans.dto.BankLoanDto;

public interface BankLoanService {

    BankLoanDto createBankLoan(BankLoanDto bankLoanDto);

    BankLoanDto findBankLoanByName(String name);
}
