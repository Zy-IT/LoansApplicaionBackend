package com.Loans.LoansApplication.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "LoanApplication" )
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loanApplicationId;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private int contactNo;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String branch;

    @Column(nullable = false)
    private String product;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String message;

    private LocalDateTime createdAt;

    public LoanApplication() {
    }

    public LoanApplication(String fullName, int contactNo, String email,
            String branch, String product, String subject, String message, LocalDateTime createdAt) {
        this.fullName = fullName;
        this.contactNo = contactNo;
        this.email = email;
        this.branch = branch;
        this.product = product;
        this.subject = subject;
        this.message = message;
        this.createdAt = createdAt;
    }

    public long getLoanApplicationId() {
        return loanApplicationId;
    }

    public void setLoanApplicationId(long loanApplicationId) {
        this.loanApplicationId = loanApplicationId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
