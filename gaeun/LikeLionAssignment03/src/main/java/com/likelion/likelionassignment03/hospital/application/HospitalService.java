package com.likelion.likelionassignment03.hospital.application;

import java.util.ArrayList;
import java.util.List;

import com.likelion.likelionassignment03.hospital.api.dto.request.HospitalSaveRequestDto;
import com.likelion.likelionassignment03.hospital.api.dto.response.HospitalInfoResponseDto;
import com.likelion.likelionassignment03.hospital.api.dto.response.HospitalListResponseDto;
import com.likelion.likelionassignment03.hospital.domain.Hospital;
import com.likelion.likelionassignment03.hospital.domain.repository.HospitalRepository;
import com.likelion.likelionassignment03.patient.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HospitalService {
    private final HospitalRepository hospitalRepository;


    @Transactional
    public void hospitalSave(HospitalSaveRequestDto hospitalSaveRequestDto) {
        Hospital hospital = Hospital.builder()
                .name(hospitalSaveRequestDto.name())
                .establishedyears(hospitalSaveRequestDto.establishedyears())
                .location(hospitalSaveRequestDto.location())
                .build();
        hospitalRepository.save(hospital);
    }


    public HospitalListResponseDto hospitalFindAll() {
        List<Hospital> hospitals = hospitalRepository.findAll();
        List<HospitalInfoResponseDto> hospitalInfoResponseDtoList = hospitals.stream()
                .map(HospitalInfoResponseDto::from)
                .toList();
        return HospitalListResponseDto.from(hospitalInfoResponseDtoList);
    }


    public HospitalInfoResponseDto hospitalFindOne(Long hospitalId) {
        Hospital hospital = hospitalRepository
                .findById(hospitalId)
                .orElseThrow(IllegalArgumentException::new);
        return HospitalInfoResponseDto.from(hospital);
    }
}
