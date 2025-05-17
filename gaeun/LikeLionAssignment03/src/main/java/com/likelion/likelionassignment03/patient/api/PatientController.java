package com.likelion.likelionassignment03.patient.api;

import com.likelion.likelionassignment03.patient.api.dto.request.PatientSaveRequestDto;
import com.likelion.likelionassignment03.patient.api.dto.response.PatientListResponseDto;
import com.likelion.likelionassignment03.patient.application.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;


    @PostMapping("/save")
    public ResponseEntity<String> patientSave(@RequestBody PatientSaveRequestDto patientSaveRequestDto) {
        patientService.patientSave(patientSaveRequestDto);
        return new ResponseEntity<>("환자 저장!", HttpStatus.CREATED);
    }


    @GetMapping("/{hospitalId}")
    public ResponseEntity<PatientListResponseDto> hospitalPatientFindAll(@PathVariable("hospitalId") Long hospitalId) {
        PatientListResponseDto patientListResponseDto = patientService.patientFindByHospital(hospitalId);
        return new ResponseEntity<>(patientListResponseDto, HttpStatus.OK);
    }
}

