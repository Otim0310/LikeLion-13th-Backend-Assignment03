package com.likelion.likelionassignment03.hospital.application;

import java.util.List;

import com.likelion.likelionassignment03.hospital.api.dto.request.HospitalSaveRequestDto;
import com.likelion.likelionassignment03.hospital.api.dto.response.HospitalInfoResponseDto;
import com.likelion.likelionassignment03.hospital.api.dto.response.HospitalListResponseDto;
import com.likelion.likelionassignment03.hospital.domain.Hospital;
import com.likelion.likelionassignment03.hospital.domain.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    @Transactional
    public void saveHospital(HospitalSaveRequestDto requestDto) {
        Hospital hospital = Hospital.builder()
                .name(requestDto.name())
                .establishedYears(requestDto.establishedYears()) // camelCase 사용
                .location(requestDto.location())
                .build();
        hospitalRepository.save(hospital);
    }

    public HospitalListResponseDto getAllHospitals() {
        List<Hospital> hospitals = hospitalRepository.findAll();
        List<HospitalInfoResponseDto> hospitalInfoList = hospitals.stream()
                .map(HospitalInfoResponseDto::from)
                .toList();
        return HospitalListResponseDto.from(hospitalInfoList);
    }

    public HospitalInfoResponseDto getHospitalById(Long hospitalId) {
        Hospital hospital = hospitalRepository
                .findById(hospitalId)
                .orElseThrow(IllegalArgumentException::new);
        return HospitalInfoResponseDto.from(hospital);
    }
}

                .orElseThrow(IllegalArgumentException::new);
        return HospitalInfoResponseDto.from(hospital);
    }
}
