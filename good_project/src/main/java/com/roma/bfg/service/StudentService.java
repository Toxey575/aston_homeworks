package com.roma.bfg.service;

import com.roma.bfg.form.StudentForm;
import com.roma.bfg.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    Student addStudent(StudentForm form);

    Student deleteStudent(UUID studentId);

    List<Student> getAllStudents();

    Student getStudentById(UUID id);

}
