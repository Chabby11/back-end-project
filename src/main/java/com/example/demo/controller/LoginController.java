 package com.example.demo.controller;

 import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.models.Login;
import com.example.demo.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 @RestController
 @RequestMapping(path = "login")
 public class LoginController {
    @Autowired
    private LoginRepository loginRepository;

@PostMapping("/")
    public Login addlogin(@RequestBody Login login){
        return loginRepository.save(login);
    }
@GetMapping("/")
 public List<Login> getAll(){
     return loginRepository.findAll();
 } 
 //update 
 @PutMapping("/{id}")
 public ResponseEntity<Login> updateLogin(@PathVariable long id, @RequestBody Login login)
 {
     Login log = loginRepository.findById(id)
     .orElseThrow();
     log.setUsername(login.getUsername());
     log.setPassword(login.getPassword());
     Login login2 = loginRepository.save(log);
     return ResponseEntity.ok(login2);
 }
 @GetMapping("/{id}")
 public ResponseEntity<Login> getLoginById(@PathVariable long id)
 {
     Login log = loginRepository.findById(id)
     .orElseThrow();
     return ResponseEntity.ok(log);
 }
 @DeleteMapping("/{id}")
 public ResponseEntity<Map<String,Boolean>> deleteDoctor(@PathVariable long id)
 {
     Login log = loginRepository.findById(id)
     .orElseThrow();
     loginRepository.delete(log);

     Map<String,Boolean> response = new HashMap<>();
     response.put("Deleted",Boolean.TRUE);
     return ResponseEntity.ok(response);
 } 
}    
 