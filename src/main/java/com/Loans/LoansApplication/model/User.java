package com.Loans.LoansApplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"Users\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"userId\"", nullable=false)
    private long userId;
    @Column(name = "\"officeId\"", nullable = false)
    private String officeId;
    @Column(name = "\"username\"", nullable = false)
    private String username;
    @Column(name = "\"password\"", nullable = false)
    private String password;
    @Column(name = "\"branch\"", nullable = false)
    private String branch;

    public User() {
    }

    public User(String officeId, String username, String password, String branch) {
        this.officeId = officeId;
        this.username = username;
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

    public String getUserName() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
