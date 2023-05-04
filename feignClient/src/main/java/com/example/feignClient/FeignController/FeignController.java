package com.example.feignClient.FeignController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.feignClient.ClientDemo.StudentClient;
import com.example.feignClient.Exception.StudentNotFoundException;
import com.example.feignClient.Model.StudentModel;

@RestController
@ControllerAdvice
@RequestMapping("/api")
public class FeignController 
{
	@Autowired
	private StudentClient studentClient;
	
	@GetMapping("/students")
    public List<StudentModel> getAllStudents() {
        return studentClient.getAllStudents();
    }
	
	@GetMapping("/students/{id}")
    public ResponseEntity<StudentModel> getStudentById(@PathVariable Long id) throws StudentNotFoundException{
        return studentClient.getStudentById(id);
    }
	
	@PostMapping("/students")
	public ResponseEntity<StudentModel> createStudent(@RequestBody StudentModel student)
	{
		return studentClient.createStudent(student);
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<StudentModel> updateStudent(@PathVariable Long id, @RequestBody StudentModel student) throws StudentNotFoundException
	{
		return studentClient.updateStudent(id, student);
	}
	
	@DeleteMapping("/students/id")
	public void deleteStudent(@PathVariable Long id) throws StudentNotFoundException
	{
		studentClient.deleteStudent(id);
	}
}
