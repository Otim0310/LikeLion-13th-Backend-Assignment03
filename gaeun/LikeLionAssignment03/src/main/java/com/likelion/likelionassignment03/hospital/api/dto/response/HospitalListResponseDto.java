package com.likelion.likelionassignment03.hospital.api.dto.response;

import com.likelion.likelionassignment03.hospital.api.dto.response.HospitalInfoResponseDto;
import lombok.Builder;

import java.util.List;

@Builder
public record HospitalListResponseDto(
        List<HospitalInfoResponseDto> hospitals
) {
    public static HospitalListResponseDto from(List<HospitalInfoResponseDto> hospitals) {
        return HospitalListResponseDto.builder()
                .hospitals(hospitals)
                .build();
    }
}
