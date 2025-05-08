package com.Loans.LoansApplication.dto;

import jakarta.validation.constraints.NotBlank;

public class UserDTO {

    private long userId;
    @NotBlank(message = "Office Id is Required")
    private String officeId;
    @NotBlank(message = "Password is Required")
    private String password;
    @NotBlank(message = "Branch is Required")
    private String branch;

    public UserDTO() {
    }

    public UserDTO(String officeId, String password, String branch) {
        this.officeId = officeId;
        this.password = password;
        this.branch = branch;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
