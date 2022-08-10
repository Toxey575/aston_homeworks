package com.roma.bfg.repository;

import com.roma.bfg.model.Student;

import java.util.List;
import java.util.UUID;


public interface StudentRepository {

    Student createStudent(Student student);

    Student deleteStudent(UUID id);

    List<Student> getAllStudents();

    Student getStudentById(UUID id);

}
