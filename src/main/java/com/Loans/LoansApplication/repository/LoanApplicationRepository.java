package com.Loans.LoansApplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Loans.LoansApplication.model.LoanApplication;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

    List<LoanApplication> findByBranch(String branch);

    Optional<LoanApplication> findByLoanApplicationId(Long loanApplicationId);

}
