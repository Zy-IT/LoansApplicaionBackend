package com.Loans.LoansApplication.repository;

import com.Loans.LoansApplication.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

    Optional<LoanApplication> findByLoanApplicationId(Long loanApplicationId);

}
