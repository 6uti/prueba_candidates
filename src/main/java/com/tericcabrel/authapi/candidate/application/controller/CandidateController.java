package com.tericcabrel.authapi.candidate.application.controller;

import com.tericcabrel.authapi.candidate.application.request.RegisterCandidateDto;
import com.tericcabrel.authapi.candidate.domain.model.Candidate;
import com.tericcabrel.authapi.candidate.domain.services.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/candidates")
@RestController
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/me")
    public ResponseEntity<Candidate> authenticatedCandidate() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Candidate currentCandidate = (Candidate) authentication.getPrincipal();

        return ResponseEntity.ok(currentCandidate);
    }

    @GetMapping("/allCandidates")
    public ResponseEntity<List<Candidate>> allCandidates() {
        List<Candidate> users = candidateService.allUsers();

        return ResponseEntity.ok(users);
    }


    @PutMapping("/update/{id}")
    public RegisterCandidateDto update(@PathVariable("id") int id, @RequestBody RegisterCandidateDto candidates) {
        //andidateService
        candidateService.saveOrUpdate(id, candidates);

        return candidates;
    }

    @DeleteMapping("/delete/{id}")
    private void deleteBook(@PathVariable("id") int id) {
        candidateService.delete(id);
    }

}
