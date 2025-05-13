package com.Loans.LoansApplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Loans.LoansApplication.dto.LoanApplicationDTO;
import com.Loans.LoansApplication.service.LoanApplicationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Api/LoanApplication")
public class LoanApplicationController {

    private final LoanApplicationService loanApplicationService;

    public LoanApplicationController(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @PostMapping("/Apply")
    public ResponseEntity<LoanApplicationDTO> createLoanApplication(@Valid @RequestBody LoanApplicationDTO loanApplicationDTO) {
        LoanApplicationDTO createdLoanApplication = loanApplicationService.postLoanApplication(loanApplicationDTO);
        return new ResponseEntity<>(createdLoanApplication, HttpStatus.CREATED);
    }

    @PostMapping("/GetOne")
    public ResponseEntity<LoanApplicationDTO> fetchOneLoanApplication(@Valid @RequestBody LoanApplicationDTO loanApplicationDto) {
        LoanApplicationDTO fetchedSingleLoanApp = loanApplicationService.getLoanByLoanApplicationId(loanApplicationDto.getLoanApplicationId());
        return new ResponseEntity<>(fetchedSingleLoanApp, HttpStatus.OK);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<LoanApplicationDTO>> fetchAllLoanApplication() {
        List<LoanApplicationDTO> fetchedLoanApplication = loanApplicationService.getAllLoanApplications();
        return new ResponseEntity<>(fetchedLoanApplication, HttpStatus.OK);
    }

    @GetMapping("/GetAll/ByBranch/{officeId}")
    public ResponseEntity<List<LoanApplicationDTO>> fetchAllLoanApplicationByBranch(@PathVariable String officeId) {
        List<LoanApplicationDTO> loanByBranch = loanApplicationService.getAllLoanByOfficeId(officeId);
        return new ResponseEntity<>(loanByBranch, HttpStatus.OK);
    }

    @ExceptionHandler()
    public ResponseEntity<String> handleRunTimeException(RuntimeException ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
