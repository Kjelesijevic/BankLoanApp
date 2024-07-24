package com.sapfioneer.bankloans.service;

import com.sapfioneer.bankloans.domain.BankLoan;
import com.sapfioneer.bankloans.dto.BankLoanDto;
import com.sapfioneer.bankloans.mapper.BankLoanMapper;
import com.sapfioneer.bankloans.repository.BankLoanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BankLoanServiceImpl implements BankLoanService {

    private final BankLoanRepository bankLoanRepository;


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
        Optional<BankLoan> bankLoanOptional = bankLoanRepository.findByName(name);
        return bankLoanOptional.map(BankLoanMapper::map).orElse(null);
    }
}
