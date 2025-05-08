package com.Loans.LoansApplication.controller;

import org.springframework.web.bind.annotation.*;

import com.Loans.LoansApplication.service.LoanApplicationService;
import com.Loans.LoansApplication.dto.LoanApplicationDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
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

    @ExceptionHandler()
    public ResponseEntity<String> handleRunTimeException(RuntimeException ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
