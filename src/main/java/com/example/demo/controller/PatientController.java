package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.models.Patient;
import com.example.demo.repository.PatientRepository;
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
@RequestMapping("api/patient")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

@PostMapping("/")
    public Patient post(@RequestBody Patient patient){
      return  patientRepository.save(patient);
    }
@GetMapping("/")
 public List<Patient> getAll(){
     return patientRepository.findAll();
 }
 //update 
 @PutMapping("/{id}")
 public ResponseEntity<Patient> updatePatient(@PathVariable long id, @RequestBody Patient patient)
 {
     Patient pt = patientRepository.findById(id)
     .orElseThrow();
     pt.setPatient_name(patient.getPatient_name());
     pt.setPatient_second_name(patient.getPatient_second_name());
     pt.setPatient_last_name(patient.getPatient_last_name());
     pt.setAddress(patient.getAddress());
     pt.setPhone_number(patient.getPhone_number());
     pt.setAge(patient.getAge());
     pt.setPhone_number(patient.getPhone_number());
     pt.setDate(patient.getDate());
     pt.setGender(patient.getGender());
     Patient patient2 = patientRepository.save(pt);
     return ResponseEntity.ok(patient2);
 }
 @GetMapping("/{id}")
 public ResponseEntity<Patient> getPatientById(@PathVariable long id)
 {
     Patient pt = patientRepository.findById(id)
     .orElseThrow();
     return ResponseEntity.ok(pt);
 }
 @DeleteMapping("/{id}")
 public ResponseEntity<Map<String,Boolean>> deletPatient(@PathVariable long id)
 {
     Patient pt = patientRepository.findById(id)
     .orElseThrow();
     patientRepository.delete(pt);

     Map<String,Boolean> response = new HashMap<>();
     response.put("Deleted",Boolean.TRUE);
     return ResponseEntity.ok(response);
 }      
}
