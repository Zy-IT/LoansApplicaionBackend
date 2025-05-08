package com.Loans.LoansApplication.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.Loans.LoansApplication.repository.LoanApplicationRepository;
import com.Loans.LoansApplication.dto.LoanApplicationDTO;
import com.Loans.LoansApplication.model.LoanApplication;

@Service
public class LoanApplicationService {

    private final LoanApplicationRepository loanApplicationRepository;

    public LoanApplicationService(LoanApplicationRepository loanApplicationRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
    }

    //Converts Entity to DTO 
    private LoanApplicationDTO convertToDTO(LoanApplication loanApplication) {
        LoanApplicationDTO loanApplicationDTO = new LoanApplicationDTO();
        loanApplicationDTO.setLoanApplicationId(loanApplication.getLoanApplicationId());
        loanApplicationDTO.setFullName(loanApplication.getFullName());
        loanApplicationDTO.setContactNo(loanApplication.getContactNo());
        loanApplicationDTO.setEmail(loanApplication.getEmail());
        loanApplicationDTO.setBranch(loanApplication.getBranch());
        loanApplicationDTO.setProduct(loanApplication.getProduct());
        loanApplicationDTO.setSubject(loanApplication.getSubject());
        loanApplicationDTO.setMessage(loanApplication.getMessage());
        return loanApplicationDTO;
    }

    //Fetch all the Data for Display 
    public List<LoanApplicationDTO> getAllLoanApplications() {
        List<LoanApplication> loanApplications = loanApplicationRepository.findAll();
        return loanApplications.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //Logic Prepared for fetching with the use of Id
    public LoanApplicationDTO getLoanByLoanApplicationId(Long loanApplicationId) {
        LoanApplication loanApplication = loanApplicationRepository.findByLoanApplicationId(loanApplicationId)
                .orElseThrow(() -> new RuntimeException("LoanApplication not found"));

        return convertToDTO(loanApplication);
    }

    //Create New Loan Application
    public LoanApplicationDTO postLoanApplication(LoanApplicationDTO loanApplicationDTO) {
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setFullName(loanApplicationDTO.getFullName());
        loanApplication.setContactNo(loanApplicationDTO.getContactNo());
        loanApplication.setEmail(loanApplicationDTO.getEmail());
        loanApplication.setBranch(loanApplicationDTO.getBranch());
        loanApplication.setProduct(loanApplicationDTO.getProduct());
        loanApplication.setSubject(loanApplicationDTO.getSubject());
        loanApplication.setMessage(loanApplicationDTO.getMessage());
        LoanApplication savedLoanApplication = loanApplicationRepository.save(loanApplication);
        return convertToDTO(savedLoanApplication);
    }

}
