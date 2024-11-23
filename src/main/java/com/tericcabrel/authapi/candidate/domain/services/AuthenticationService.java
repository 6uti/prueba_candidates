package com.tericcabrel.authapi.candidate.domain.services;

import com.tericcabrel.authapi.candidate.application.request.LoginCandidateDto;
import com.tericcabrel.authapi.candidate.application.request.RegisterCandidateDto;
import com.tericcabrel.authapi.candidate.domain.model.Candidate;
import com.tericcabrel.authapi.candidate.infrastructure.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {
    private final CandidateRepository candidateRepository;
    //private final 
    private final AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder passwordEncoder;

    public AuthenticationService(
            CandidateRepository candidateRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.candidateRepository = candidateRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Candidate signup(RegisterCandidateDto input) {
        var user = new Candidate()
                .setName(input.getName())
                .setGender(input.getGender())
                .setSalary_expected(input.getSalary_expected())
                .setEmail(input.getEmail())
                .setPassword(passwordEncoder.encode(input.getPassword()));

        return candidateRepository.save(user);
    }

    public Candidate authenticate(LoginCandidateDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return candidateRepository.findByEmail(input.getEmail()).orElseThrow();
    }

    public List<Candidate> allUsers() {
        List<Candidate> users = new ArrayList<>();

        candidateRepository.findAll().forEach(users::add);

        return users;
    }
}
