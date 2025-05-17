package com.likelion.likelionassignment03.patient.api.dto.request;

public record PatientSaveRequestDto(
        String name,
        int age,
        String causes,
        Long hospitalId
) {
}
