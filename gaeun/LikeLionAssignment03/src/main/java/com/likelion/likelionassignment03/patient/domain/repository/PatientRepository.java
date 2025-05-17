package com.likelion.likelionassignment03.patient.domain.repository;

import com.likelion.likelionassignment03.hospital.domain.Hospital;
import com.likelion.likelionassignment03.patient.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByHospital(Hospital hospital);
}
