package com.tericcabrel.authapi.candidate.infrastructure;

import com.tericcabrel.authapi.candidate.domain.model.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
    Optional<Candidate> findByEmail(String email);
}
