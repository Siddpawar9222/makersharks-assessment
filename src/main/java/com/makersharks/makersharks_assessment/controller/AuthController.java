package com.makersharks.makersharks_assessment.controller;

import com.makersharks.makersharks_assessment.dto.UserDto;
import com.makersharks.makersharks_assessment.exception.BadRequestException;
import com.makersharks.makersharks_assessment.exception.LoginException;
import com.makersharks.makersharks_assessment.exception.ResourceUnavailableException;
import com.makersharks.makersharks_assessment.exception.UsernameAlreadyExistException;
import com.makersharks.makersharks_assessment.model.Response;
import com.makersharks.makersharks_assessment.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService ;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody @Valid UserDto userDto) throws BadRequestException, ResourceUnavailableException, UsernameAlreadyExistException {
        return ResponseEntity.ok(authService.registerUser(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> authenticateUser(@RequestBody @Valid UserDto userDto) throws LoginException {
           return  ResponseEntity.ok(authService.authenticateAndGetToken(userDto));
    }

//    @GetMapping("/allRegisteredUser")
//    public ResponseEntity<Response> getAllRegister() {
//        return ResponseEntity.ok(authService.getAllRegisteredUsers());
//    }
}
