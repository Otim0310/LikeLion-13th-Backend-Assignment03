package com.likelion.likelionassignment03.patient.application;

import com.likelion.likelionassignment03.hospital.domain.Hospital;
import com.likelion.likelionassignment03.hospital.domain.repository.HospitalRepository;
import com.likelion.likelionassignment03.patient.api.dto.request.PatientSaveRequestDto;
import com.likelion.likelionassignment03.patient.api.dto.response.PatientInfoResponseDto;
import com.likelion.likelionassignment03.patient.api.dto.response.PatientListResponseDto;
import com.likelion.likelionassignment03.patient.domain.Patient;
import com.likelion.likelionassignment03.patient.domain.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PatientService {

    private final HospitalRepository hospitalRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public void patientSave(PatientSaveRequestDto patientSaveRequestDto) {
        // 여기서 계속 오류났음 ->오류 분석 맡기니까 id가 null이라는데..그것때문에 여기서는 gpt에게 물어봄->아직 이해 안돼었음..
        if (patientSaveRequestDto.hospitalId() == null) {
            throw new IllegalArgumentException("병원 ID가 null입니다. 환자를 저장하려면 병원 ID가 필요합니다.");
        }


        Hospital hospital = hospitalRepository.findById(patientSaveRequestDto.hospitalId())
                .orElseThrow(() -> new IllegalArgumentException("해당 병원을 찾을 수 없습니다. ID: " + patientSaveRequestDto.hospitalId()));


        Patient patient = Patient.builder()
                .age(patientSaveRequestDto.age())
                .causes(patientSaveRequestDto.causes())
                .hospital(hospital)
                .build();

        patientRepository.save(patient);
    }

    public PatientListResponseDto patientFindByHospital(Long hospitalId) {
        if (hospitalId == null) {
            throw new IllegalArgumentException("병원 ID는 필수입니다.");
        }

        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new IllegalArgumentException("해당 병원을 찾을 수 없습니다. ID: " + hospitalId));

        List<Patient> patients = patientRepository.findByHospital(hospital);
        List<PatientInfoResponseDto> patientInfoResponseDtos = patients.stream()
                .map(PatientInfoResponseDto::from)
                .toList();

        return PatientListResponseDto.from(patientInfoResponseDtos);
    }
}
