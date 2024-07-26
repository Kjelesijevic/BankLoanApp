package com.sapfioneer.bankloans.repository;

import com.sapfioneer.bankloans.domain.BankLoan;
import com.sapfioneer.bankloans.domain.LoanRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRequestRepository  extends JpaRepository<LoanRequest, Integer> {
}