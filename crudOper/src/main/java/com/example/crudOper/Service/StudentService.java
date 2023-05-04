package com.example.crudOper.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.crudOper.Entity.StudentModel;
import com.example.crudOper.Exception.StudentNotFoundException;
import com.example.crudOper.Repo.StudentRepository;

@Service
public class StudentService 
{
	@Autowired
    private StudentRepository studentRepository;
	
    public List<StudentModel> getAllStudents() {
        return studentRepository.findAll();
    }

    public ResponseEntity<StudentModel> getStudentById(@PathVariable Long id) throws StudentNotFoundException{
        Optional<StudentModel> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
        	throw new StudentNotFoundException("User not found with id " + id);
        }
    }

    public ResponseEntity<StudentModel> createStudent(@RequestBody StudentModel student) {
        StudentModel createdStudent = studentRepository.save(student);
        return ResponseEntity.created(URI.create("/api/students/" + createdStudent.getId())).body(createdStudent);
    }

    public ResponseEntity<StudentModel> updateStudent(@PathVariable Long id, @RequestBody StudentModel student) throws StudentNotFoundException{
        Optional<StudentModel> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            StudentModel updatedStudent = existingStudent.get();
            updatedStudent.setStudentName(student.getStudentName());
            updatedStudent.setStudentMail(student.getStudentMail());
            updatedStudent.setStudentCity(student.getStudentCity());
            studentRepository.save(updatedStudent);
            return ResponseEntity.ok(updatedStudent);
        } else {
        	throw new StudentNotFoundException("User not found with id " + id);
        }
    }

    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) throws StudentNotFoundException{
        Optional<StudentModel> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            studentRepository.delete(existingStudent.get());
            return ResponseEntity.noContent().build();
        } else {
        	throw new StudentNotFoundException("User not found with id " + id);
        }
    }
}
