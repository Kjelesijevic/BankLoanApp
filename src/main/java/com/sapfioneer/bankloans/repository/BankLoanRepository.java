package com.sapfioneer.bankloans.repository;

import com.sapfioneer.bankloans.domain.BankLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankLoanRepository extends JpaRepository<BankLoan, Integer> {
    Optional<BankLoan> findByName(String name);
    //JpaRepository sadrzi save, delete, ne mora rucno da se implementiraju
}
