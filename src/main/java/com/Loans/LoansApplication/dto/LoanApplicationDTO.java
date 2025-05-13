package com.Loans.LoansApplication.dto;

import jakarta.validation.constraints.NotBlank;

public class LoanApplicationDTO {

    private long loanApplicationId;
    @NotBlank(message = "Full Name is required")
    private String fullName;
    @NotBlank(message = "Contact Number is required")
    private String contactNo;
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Branch is required")
    private String branch;
    @NotBlank(message = "Product is required")
    private String product;
    @NotBlank(message = "Subject is required")
    private String subject;
    @NotBlank(message = "Message is required")
    private String message;

    public LoanApplicationDTO() {
    }

    public LoanApplicationDTO(String fullName, String contactNo, String email,
            String branch, String product, String subject, String message) {
        this.fullName = fullName;
        this.contactNo = contactNo;
        this.email = email;
        this.branch = branch;
        this.product = product;
        this.subject = subject;
        this.message = message;
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

    @Override
    public String toString() {
        return "LoanApplicationDTO{"
                + "loanApplicationId='" + loanApplicationId + '\''
                + ", branch='" + branch + '\''
                + ", fullName='" + fullName + '\''
                + ", email='" + email + '\''
                + ", product='" + product + '\''
                + ", subject='" + subject + '\''
                + '}';
    }
}
