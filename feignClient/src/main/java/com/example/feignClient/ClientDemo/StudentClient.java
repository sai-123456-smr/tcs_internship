package com.example.feignClient.ClientDemo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.feignClient.Model.StudentModel;

@FeignClient(name = "crudOper")
public interface StudentClient 
{
	@GetMapping("/api/students")
    List<StudentModel> getAllStudents();

    @GetMapping("/api/students/{id}")
    ResponseEntity<StudentModel> getStudentById(@PathVariable Long id);

    @PostMapping("/api/students")
    ResponseEntity<StudentModel> createStudent(@RequestBody StudentModel student);

    @PutMapping("/api/students/{id}")
    ResponseEntity<StudentModel> updateStudent(@PathVariable Long id, @RequestBody StudentModel student);

    @DeleteMapping("/api/students/{id}")
    ResponseEntity<Void> deleteStudent(@PathVariable Long id);
}
