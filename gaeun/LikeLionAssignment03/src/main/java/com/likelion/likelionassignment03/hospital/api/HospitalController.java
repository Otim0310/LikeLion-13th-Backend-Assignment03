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
@RequestMapping("/hospital")
public class HospitalController {

    private final HospitalService hospitalService;


    @PostMapping("/save")
    public ResponseEntity<String> hospitalSave(@RequestBody HospitalSaveRequestDto hospitalSaveRequestDto) {
        hospitalService.hospitalSave(hospitalSaveRequestDto);
        return new ResponseEntity<>("병원 저장!", HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<HospitalListResponseDto> hospitalFindAll() {
        HospitalListResponseDto hospitalListResponseDto = hospitalService.hospitalFindAll();
        return new ResponseEntity<>(hospitalListResponseDto, HttpStatus.OK);
    }


    @GetMapping("/{hospitalId}")
    public ResponseEntity<HospitalInfoResponseDto> hospitalFindOne(@PathVariable("hospitalId") Long hospitalId) {
        HospitalInfoResponseDto hospitalInfoResponseDto = hospitalService.hospitalFindOne(hospitalId);
        return new ResponseEntity<>(hospitalInfoResponseDto, HttpStatus.OK);
    }
}
