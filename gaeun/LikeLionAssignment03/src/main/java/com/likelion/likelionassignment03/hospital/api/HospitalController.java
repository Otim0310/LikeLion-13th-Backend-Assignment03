package com.likelion.likelionassignment03.hospital.api;

import com.likelion.likelionassignment03.hospital.api.dto.request.HospitalSaveRequestDto;
import com.likelion.likelionassignment03.hospital.api.dto.response.HospitalInfoResponseDto;
import com.likelion.likelionassignment03.hospital.api.dto.response.HospitalListResponseDto;
import com.likelion.likelionassignment03.hospital.application.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;

    @PostMapping
    public ResponseEntity<String> saveHospital(@RequestBody HospitalSaveRequestDto requestDto) {
        hospitalService.saveHospital(requestDto);
        return new ResponseEntity<>("병원 저장!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<HospitalListResponseDto> getAllHospitals() {
        HospitalListResponseDto responseDto = hospitalService.getAllHospitals();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/{hospitalId}")
    public ResponseEntity<HospitalInfoResponseDto> getHospitalById(@PathVariable Long hospitalId) {
        HospitalInfoResponseDto responseDto = hospitalService.getHospitalById(hospitalId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
