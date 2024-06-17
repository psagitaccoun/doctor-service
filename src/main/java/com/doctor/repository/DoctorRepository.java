package com.doctor.repository;

import com.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,String>{

    List<Doctor> findBySpecialization(String spl);
}
