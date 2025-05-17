package com.likelion.likelionassignment03.hospital.api.dto.response;

import com.likelion.likelionassignment03.hospital.domain.Hospital;
import com.likelion.likelionassignment03.hospital.domain.Location;
import lombok.Builder;

@Builder
public record HospitalInfoResponseDto(
        String name,
        int establishedyears,
        Location location
) {
    public static HospitalInfoResponseDto from(Hospital hospital) {
        return HospitalInfoResponseDto.builder()
                .name(hospital.getName())
                .establishedyears(hospital.getEstablishedyears())
                .location(hospital.getLocation())
                .build();
    }
}

