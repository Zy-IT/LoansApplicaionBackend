package com.Loans.LoansApplication.service;

import org.springframework.stereotype.Service;

import com.Loans.LoansApplication.dto.UserDTO;
import com.Loans.LoansApplication.dto.LoginDTO;
import com.Loans.LoansApplication.model.User;
import com.Loans.LoansApplication.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO ConvertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setOfficeId(user.getOfficeId());
        userDTO.setPassword(user.getPassword());
        userDTO.setBranch(user.getPassword());
        return userDTO;
    }

    public UserDTO getUserByOfficeID(String officeId) {
        User user = userRepository.findByOfficeId(officeId)
                .orElseThrow(() -> new RuntimeException("User not found with officeId: " + officeId));
        return ConvertToDTO(user);
    }

    public UserDTO getUserByBranch(String branch) {
        User user = userRepository.findByBranch(branch)
                .orElseThrow(() -> new RuntimeException("User not found with branch: " + branch));
        return ConvertToDTO(user);
    }

    public UserDTO loginUser(LoginDTO loginDTO) {
        User user = userRepository.findByOfficeId(loginDTO.getOfficeId())
                .orElseThrow(() -> new RuntimeException("User ID not found"));

        if (!user.getPassword().equals(loginDTO.getPassword())) {
            throw new RuntimeException("Password is Wrong");
        }
        return ConvertToDTO(user);
    }
}
