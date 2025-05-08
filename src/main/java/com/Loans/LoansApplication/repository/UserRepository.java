package com.Loans.LoansApplication.repository;

import java.util.Optional;

import com.Loans.LoansApplication.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByOfficeId(String officeId);
    Optional<User> findByPassword(String password);
    Optional<User> findByBranch(String branch);
}
