package com.sapfioneer.bankloans.controller;

import com.sapfioneer.bankloans.dto.BankLoanDto;
import com.sapfioneer.bankloans.service.BankLoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j //biblioteka za logovanje, tipa log.info() metoda
@RestController //anotacija da front gadja API request
@RequestMapping("bank-loan") // domen/bank-loan/"create"
@RequiredArgsConstructor
public class BankLoanController {

    private final BankLoanService bankLoanService;

    @GetMapping(path = "/{name}")
    public BankLoanDto findBankLoanById(@PathVariable String name) {
        log.info("request for finding bank loan by name: {}", name);
        return bankLoanService.findBankLoanByName(name);
    }

    @PostMapping(path = "/create")
    public BankLoanDto createLoan(@RequestBody BankLoanDto bankLoanDto) {
        log.info("request for creating new bank loan, BankLoanDto: {}", bankLoanDto);
        return bankLoanService.createBankLoan(bankLoanDto);
    }
}
