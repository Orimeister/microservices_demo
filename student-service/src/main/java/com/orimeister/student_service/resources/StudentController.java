package com.orimeister.student_service.resources;

import com.orimeister.student_service.model.Student;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public ResponseEntity<?> fetchAllStudents(){
        return studentService.findAllStudents();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> fetchStudent(@PathVariable Integer id){
        return studentService.findStudent(id);
    }
    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
}
