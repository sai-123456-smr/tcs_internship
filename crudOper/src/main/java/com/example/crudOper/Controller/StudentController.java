package com.example.crudOper.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudOper.Entity.StudentModel;
import com.example.crudOper.Exception.StudentNotFoundException;
import com.example.crudOper.Service.StudentService;

@RestController
@RefreshScope
@RequestMapping("/api/students")
public class StudentController 
{
	@Autowired
    private StudentService studentService;

	@Value("${changecity}")
	private String changecity;
    @GetMapping
    public List<StudentModel> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentModel> getStudent(@PathVariable Long id) throws StudentNotFoundException {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public ResponseEntity<StudentModel> saveStudent(@RequestBody StudentModel student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentModel> updateStudent(@PathVariable Long id, @RequestBody StudentModel student) throws StudentNotFoundException {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) throws StudentNotFoundException {
        studentService.deleteStudent(id);
    }
    
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(StudentNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
