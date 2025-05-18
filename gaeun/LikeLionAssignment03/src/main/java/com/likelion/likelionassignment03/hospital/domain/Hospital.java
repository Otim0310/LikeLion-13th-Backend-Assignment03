package com.likelion.likelionassignment03.hospital.domain;

import com.likelion.likelionassignment03.patient.domain.Patient;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private Long hospitalId;

    private String name;

    private int establishedYears;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Location location;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Patient> patients = new ArrayList<>();

    @Builder
    private Hospital(String name, int establishedYears, Location location) {
        this.name = name;
        this.establishedYears = establishedYears;
        this.location = location;
    }
}
