package com.mohit.hospitalManagement;

import com.mohit.hospitalManagement.entity.Insurance;
import com.mohit.hospitalManagement.entity.Patient;
import com.mohit.hospitalManagement.repository.InsuranceRepository;
import com.mohit.hospitalManagement.repository.PatientRepository;
import com.mohit.hospitalManagement.service.InsuranceService;
import com.mohit.hospitalManagement.entity.type.BloodGroupType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testCreateAndAssignInsuranceToPatient() {
        // Create a patient
        Patient patient = new Patient();
        patient.setName("Test Patient");
        patient.setEmail("test.patient@example.com");
        patient.setBloodGroup(BloodGroupType.O_POSITIVE);
        patient.setGender("MALE");
        patient.setBirthDate(LocalDate.of(2000, 1, 1));
        patient = patientRepository.save(patient);

        // Create insurance
        Insurance insurance = new Insurance();
        insurance.setPolicyNumber("POL123456");
        insurance.setProvider("Test Provider");
        insurance.setValidUntil(LocalDate.now().plusYears(1));
        insurance = insuranceRepository.save(insurance);

        // Assign insurance to patient
        Patient updatedPatient = insuranceService.assignInsuranceToPatient(insurance, patient.getId());
        Assertions.assertNotNull(updatedPatient.getInsurance());
        Assertions.assertEquals("POL123456", updatedPatient.getInsurance().getPolicyNumber());
        Assertions.assertEquals("Test Provider", updatedPatient.getInsurance().getProvider());
    }
}
