package com.likelion.likelionassignment03.patient.api.dto.response;

import com.likelion.likelionassignment03.patient.api.dto.response.PatientInfoResponseDto;
import lombok.Builder;

import java.util.List;

@Builder
public record PatientListResponseDto(
        List<PatientInfoResponseDto> patients
) {
    public static PatientListResponseDto from(List<PatientInfoResponseDto> patients) {
        return PatientListResponseDto.builder()
                .patients(patients)
                .build();
    }
}
