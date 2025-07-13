package com.mohit.hospitalManagement.repository;

import com.mohit.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//now with this you can run query
public interface PatientRepository extends JpaRepository<Patient,Long> {

}
