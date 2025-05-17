package com.likelion.likelionassignment03.hospital.api.dto.request;

import com.likelion.likelionassignment03.hospital.domain.Location;

public record HospitalSaveRequestDto(
        String name,
        int establishedyears,
        Location location
) {
}
