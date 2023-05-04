package com.example.crudOper.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crudOper.Entity.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Long>{

}
