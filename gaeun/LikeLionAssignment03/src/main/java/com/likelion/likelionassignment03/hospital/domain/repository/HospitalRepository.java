package com.likelion.likelionassignment03.hospital.domain.repository;

import com.likelion.likelionassignment03.hospital.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Optional<Object> findByName(String name);
}



