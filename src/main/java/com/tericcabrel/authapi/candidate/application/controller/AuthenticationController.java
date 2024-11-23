package com.tericcabrel.authapi.candidate.application.controller;

import com.tericcabrel.authapi.candidate.application.request.LoginCandidateDto;
import com.tericcabrel.authapi.candidate.application.request.RegisterCandidateDto;
import com.tericcabrel.authapi.candidate.application.response.LoginResponse;
import com.tericcabrel.authapi.candidate.domain.model.Candidate;
import com.tericcabrel.authapi.candidate.domain.services.AuthenticationService;
import com.tericcabrel.authapi.candidate.domain.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Candidate> register(@RequestBody RegisterCandidateDto registerCandidateDto) {
        Candidate registeredUser = authenticationService.signup(registerCandidateDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginCandidateDto loginCandidateDto) {
        Candidate authenticatedUser = authenticationService.authenticate(loginCandidateDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}