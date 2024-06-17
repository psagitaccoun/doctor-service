package com.doctor.controller;

// DoctorController class
import com.doctor.entity.Doctor;
import com.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/spl/{spl}")
    public List<Doctor> getAllBySpl(@PathVariable String spl){
        List<Doctor> allBySpl = doctorService.findAllBySpl(spl);
        return allBySpl;
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable String id) {
        return doctorService.findById(id);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.findAll();
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.save(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctorById(@PathVariable String id) {
        doctorService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable String id,@RequestBody Doctor doctor){
        doctorService.update(id,doctor);
        return doctor;
    }

    // Add more endpoints as needed
}
