 package com.example.demo.repository;

 import com.example.demo.models.Doctor;

 import org.springframework.data.jpa.repository.JpaRepository;

 ;

 public interface  DoctorRepository extends JpaRepository<Doctor, Long> {

    
 }
