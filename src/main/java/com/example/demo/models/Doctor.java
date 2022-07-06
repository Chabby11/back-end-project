 package com.example.demo.models;

 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

 @Data
 @Entity
 @Table
 public class Doctor{
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     private String doctor_first_name;
     private String second_name;
     private String last_name;
     private String name_of_tablets;
     private int date;
     private String how_to_use_medicine;
     private int dose;
     private int phone_number;
     private String possible_side_effects;
 }






