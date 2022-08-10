package com.roma.bfg.service.impl;

import com.roma.bfg.form.StudentForm;
import com.roma.bfg.model.Student;
import com.roma.bfg.repository.StudentRepository;
import com.roma.bfg.service.StudentService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(StudentForm form) {

        Student student = Student.builder()
                .name(form.getName())
                .build();

        return studentRepository.createStudent(student);

    }

    @Override
    public Student deleteStudent(UUID studentId) {

        return studentRepository.deleteStudent(studentId);

    }

    @Override
    public List<Student> getAllStudents() {

        return studentRepository.getAllStudents();

    }

    @Override
    public Student getStudentById(UUID id) {

        return studentRepository.getStudentById(id);

    }
}
