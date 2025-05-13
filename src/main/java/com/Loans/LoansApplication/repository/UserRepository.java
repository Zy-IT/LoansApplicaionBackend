package com.Loans.LoansApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Loans.LoansApplication.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByOfficeId(String officeId);

    Optional<User> findByUsername(String username);

    Optional<User> findByPassword(String password);

    Optional<User> findByBranch(String branch);
}
