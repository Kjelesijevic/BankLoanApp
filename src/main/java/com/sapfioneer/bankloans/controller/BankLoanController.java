package com.sapfioneer.bankloans.controller;

import com.sapfioneer.bankloans.dto.BankLoanDto;
import com.sapfioneer.bankloans.dto.LoanDetailsDto;
import com.sapfioneer.bankloans.dto.LoanRequestDto;
import com.sapfioneer.bankloans.repository.BankLoanRepository;
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

    @PostMapping(path = "/create")
    public BankLoanDto createLoan(@RequestBody BankLoanDto bankLoanDto) {
        log.info("request for creating new bank loan, BankLoanDto: {}", bankLoanDto);
        return bankLoanService.createBankLoan(bankLoanDto);
    }

    @GetMapping(path = "/{name}")
    public BankLoanDto findBankLoanById(@PathVariable String name) {
        log.info("request for finding bank loan by name: {}", name);
        return bankLoanService.findBankLoanByName(name);
    }

    @GetMapping(path = "/details/{name}")
    public LoanDetailsDto findLoanDetails(@PathVariable String name) {
        log.info("request for finding details of bank loan by name: {}", name);
        return bankLoanService.findLoanDetails(name);
    }
    //Tipovi REST: Post, Get, Put, DeleteMapping; post: insert, create; Get: select; Put: update;
    //Delete: za brisanje

    @DeleteMapping (path = "/{name}")
    public void deleteLoan(@PathVariable String name) {
        bankLoanService.deleteLoan(name);
        log.info("request for delete bank loan type by name: {}", name);
    }

    @PutMapping (path = "/{oldName}")
    public BankLoanDto deleteLoan(@PathVariable String oldName, @RequestBody BankLoanDto bankLoanDto) {
        log.info("request for update bank loan type by name: {}", oldName);
        return bankLoanService.updateLoanName(oldName, bankLoanDto.getName());
    }

    @PostMapping(path = "/new-request")
    public LoanRequestDto createLoan(@RequestBody LoanRequestDto loanRequestDto) {
        log.info("request for creating new loan from customer, BankLoanDto: {}", loanRequestDto);
        return bankLoanService.createLoanRequest(loanRequestDto);
    }

}
