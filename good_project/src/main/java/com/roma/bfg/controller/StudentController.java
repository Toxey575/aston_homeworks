package com.roma.bfg.controller;

import com.roma.bfg.form.StudentForm;
import com.roma.bfg.model.Student;
import com.roma.bfg.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public Student addStudent(@RequestBody StudentForm form) {

        return studentService.addStudent(form);
    }

    @DeleteMapping("/{student-id}/delete")
    public Student deleteStudent(@PathVariable("student-id") UUID studentId) {

        return studentService.deleteStudent(studentId);
    }

    @GetMapping()
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }

    @GetMapping("/{student-id}")
    public Student getStudentById(@PathVariable("student-id") UUID id) {

        return studentService.getStudentById(id);

    }

}
