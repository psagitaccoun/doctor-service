package com.doctor.service;

// DoctorService interface
import com.doctor.entity.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor findById(String id);
    List<Doctor> findAll();
    Doctor save(Doctor doctor);
    void deleteById(String id);

    Doctor update(String id,Doctor doctor);

    List<Doctor> findAllBySpl(String spl);
    // Add more methods as needed
}
