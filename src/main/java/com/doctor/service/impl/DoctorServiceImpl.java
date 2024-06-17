package com.doctor.service.impl;

// DoctorServiceImpl class
import com.doctor.entity.Doctor;
import com.doctor.repository.DoctorRepository;
import com.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor findById(String id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        return optionalDoctor.orElse(null);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor save(Doctor doctor) {
        String string = UUID.randomUUID().toString();
        doctor.setId(string);
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteById(String id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Doctor update(String id, Doctor doctor) {

        Doctor doctor1 = doctorRepository.findById(id).orElse(null);
        doctor1.setName(doctor.getName());
        doctor1.setHospital(doctor.getHospital());
        doctor1.setSpecialization(doctor.getSpecialization());

        Doctor save = doctorRepository.save(doctor1);
        return save;
    }

    @Override
    public List<Doctor> findAllBySpl(String spl) {
        List<Doctor> list = doctorRepository.findBySpecialization(spl);
        return list;
    }

    // Add more methods as needed
}
