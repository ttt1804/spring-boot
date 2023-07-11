package com.example.uploadmultiplefiles.Repository;

import com.example.uploadmultiplefiles.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
