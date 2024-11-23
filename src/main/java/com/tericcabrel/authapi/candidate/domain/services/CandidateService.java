package com.tericcabrel.authapi.candidate.domain.services;

import com.tericcabrel.authapi.candidate.application.request.RegisterCandidateDto;
import com.tericcabrel.authapi.candidate.domain.model.Candidate;
import com.tericcabrel.authapi.candidate.infrastructure.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> allUsers() {
        List<Candidate> users = new ArrayList<>();

        candidateRepository.findAll().forEach(users::add);

        return users;
    }

    public void saveOrUpdate(Integer id, RegisterCandidateDto candidates) {
        var candidate = new Candidate()
                .setId(id)
                .setName(candidates.getName())
                .setEmail(candidates.getEmail())
                .setGender(candidates.getGender())
                .setSalary_expected(candidates.getSalary_expected())
                .setPassword(passwordEncoder.encode(candidates.getPassword()));
        
        candidateRepository.save(candidate);
    }

    public void delete(int id) {
        candidateRepository.deleteById(id);
    }

}
