 package com.example.demo.controller;

 import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.models.Doctor;
import com.example.demo.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 @CrossOrigin
 @RestController
 @RequestMapping("api/doctor")
 public class DoctorController {
     @Autowired
     private DoctorRepository doctorRepository;

 @PostMapping("/")
     public Doctor adddoctor(@RequestBody Doctor doctor){
         return doctorRepository.save(doctor);
     }
 @GetMapping("/")
  public List<Doctor> getAll(){
      return doctorRepository.findAll();
  } 
  //update 
  @PutMapping("/{id}")
  public ResponseEntity<Doctor> updateDoctor(@PathVariable long id, @RequestBody Doctor doctor)
  {
      Doctor dct = doctorRepository.findById(id)
      .orElseThrow();
      dct.setDoctor_first_name(doctor.getDoctor_first_name());
      dct.setSecond_name(doctor.getSecond_name());
      dct.setLast_name(doctor.getLast_name());
      dct.setName_of_tablets(doctor.getName_of_tablets());
      dct.setDate(doctor.getDate());
      dct.setHow_to_use_medicine(doctor.getHow_to_use_medicine());
      dct.setPhone_number(doctor.getPhone_number());
      dct.setPossible_side_effects(doctor.getPossible_side_effects());
      Doctor doctor2 = doctorRepository.save(dct);
      return ResponseEntity.ok(doctor2);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Doctor> getDoctorById(@PathVariable long id)
  {
      Doctor dct = doctorRepository.findById(id)
      .orElseThrow();
      return ResponseEntity.ok(dct);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String,Boolean>> deleteDoctor(@PathVariable long id)
  {
      Doctor dct = doctorRepository.findById(id)
      .orElseThrow();
      doctorRepository.delete(dct);

      Map<String,Boolean> response = new HashMap<>();
      response.put("Deleted",Boolean.TRUE);
      return ResponseEntity.ok(response);
  } 
 }
