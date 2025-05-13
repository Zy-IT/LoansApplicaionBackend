package com.Loans.LoansApplication.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"LoanApplication\"")
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"loanApplicationId\"", nullable=false)
    private long loanApplicationId;

    @Column(name = "\"fullName\"", nullable = false)
    private String fullName;

    @Column(name = "\"contactNo\"", nullable = false)
    private String contactNo;

    @Column(name = "\"email\"", nullable = false)
    private String email;

    @Column(name = "\"branch\"", nullable = false)
    private String branch;

    @Column(name = "\"product\"", nullable = false)
    private String product;

    @Column(name = "\"subject\"", nullable = false)
    private String subject;

    @Column(name = "\"message\"", nullable = false)
    private String message;
    
    @Column(name = "\"createdAt\"", nullable = false)
    private LocalDateTime createdAt;

    public LoanApplication() {
    }

    public LoanApplication(String fullName, String contactNo, String email,
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
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
