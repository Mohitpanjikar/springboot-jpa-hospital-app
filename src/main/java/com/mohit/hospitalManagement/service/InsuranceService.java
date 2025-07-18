package com.mohit.hospitalManagement.service;

import com.mohit.hospitalManagement.entity.Insurance;
import com.mohit.hospitalManagement.entity.Patient;
import com.mohit.hospitalManagement.repository.InsuranceRepository;
import com.mohit.hospitalManagement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id : " + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient);

        return patient;
    }
}
