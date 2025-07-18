package com.mohit.hospitalManagement;

import com.mohit.hospitalManagement.entity.Patient;
import com.mohit.hospitalManagement.repository.PatientRepository;
import com.mohit.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootTest
public class PateintTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

//    @Test
//    protected void testPatientRepository() {
//
//        List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
//        System.out.println(patientList);
//
//    }




}
