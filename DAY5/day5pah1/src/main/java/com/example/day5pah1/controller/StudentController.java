package com.example.day5pah1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.day5pah1.model.Student;
import com.example.day5pah1.service.StudentService;

@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }

    @PostMapping("/student")
    public ResponseEntity<Student> postMethodName(@RequestBody Student student) {
        if (studentService.saveStudent(student) == true) {
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(student, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> putMethodName() {
        List<Student> l = studentService.getListStudent();
        if (l.size() == 0) {
            return new ResponseEntity<>(l, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(l, HttpStatus.OK);
    }
    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> putMethodName(@PathVariable("studentId") int id) {
        Student p = studentService.getStudentById(id);
        if (p!=null) {
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
    }
    @PutMapping("/student/{studentId}")
    public ResponseEntity<Student> putMethodName(@PathVariable("studentId") int id, @RequestBody Student student) {
        if (studentService.updateDetails(id, student) == true) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        return new ResponseEntity<>(student, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/student/{studentId}")
    public boolean delete(@PathVariable("studentId") int id) {
        if (studentService.deleteStudent(id) == true) {
            return true;
        }
        return false;
    }
}
