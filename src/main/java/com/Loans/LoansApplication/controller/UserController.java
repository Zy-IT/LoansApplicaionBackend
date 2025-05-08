package com.Loans.LoansApplication.controller;

import org.springframework.web.bind.annotation.*;

import com.Loans.LoansApplication.service.UserService;

import jakarta.validation.Valid;

import com.Loans.LoansApplication.dto.UserDTO;
import com.Loans.LoansApplication.dto.LoginDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/Api/User")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/Login")
    public ResponseEntity<UserDTO> userLogin(@Valid @RequestBody LoginDTO loginDTO) {
        UserDTO userDTO = userService.loginUser(loginDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRunTimeException(RuntimeException ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
