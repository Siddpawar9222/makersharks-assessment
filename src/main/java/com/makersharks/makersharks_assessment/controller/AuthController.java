package com.makersharks.makersharks_assessment.controller;

import com.makersharks.makersharks_assessment.dto.UserDto;
import com.makersharks.makersharks_assessment.exception.BadRequestException;
import com.makersharks.makersharks_assessment.exception.LoginException;
import com.makersharks.makersharks_assessment.exception.ResourceUnavailableException;
import com.makersharks.makersharks_assessment.exception.UsernameAlreadyExistException;
import com.makersharks.makersharks_assessment.model.Response;
import com.makersharks.makersharks_assessment.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/auth")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Authentication APIs")
public class AuthController {
    private final AuthService authService ;


    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody @Valid UserDto userDto) throws BadRequestException, ResourceUnavailableException, UsernameAlreadyExistException {
        log.info("registerUser controller called ::: {} ", new Date());
        Response response = authService.registerUser(userDto);
        log.info("registerUser controller ended ::: {} ", new Date());
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getResultCode()));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> authenticateUser(@RequestBody @Valid UserDto userDto) throws LoginException {
        log.info("authenticateUser controller called ::: {} ", new Date());
        Response response = authService.authenticateAndGetToken(userDto);
        log.info("authenticateUser controller ended ::: {} ", new Date());
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getResultCode()));
    }
}
