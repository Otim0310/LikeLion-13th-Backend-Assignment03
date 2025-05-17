package com.likelion.likelionassignment03.patient.api.dto.response;

import com.likelion.likelionassignment03.patient.domain.Patient;
import lombok.Builder;

@Builder
public record PatientInfoResponseDto(
        int age,
        String causes,
        String doctor,
        Long hospitalId
) {
    public static PatientInfoResponseDto from(Patient patient) {
        return PatientInfoResponseDto.builder()
                .age(patient.getAge())
                .causes(patient.getCauses())
                .doctor(patient.getHospital().getName())
                .build();
    }
}
