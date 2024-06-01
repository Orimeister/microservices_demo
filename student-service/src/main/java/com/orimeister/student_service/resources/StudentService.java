package com.orimeister.student_service.resources;

import com.orimeister.student_service.model.School;
import com.orimeister.student_service.model.Student;
import com.orimeister.student_service.model.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RestTemplate restTemplate;
    public ResponseEntity<?> createStudent(Student student){
        try{
            Student savedStudent = studentRepository.save(student);
            return ResponseEntity.ok(savedStudent);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity<?> findAllStudents(){
        List<Student> students  = studentRepository.findAll();
        return students.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Students"):ResponseEntity.ok(students);
    }
    public ResponseEntity<?> findStudent(Integer id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()) {
            Student student = studentOptional.get();
            School school = restTemplate.getForObject("http://localhost:8082/api/school/" + student.getSchoolId(), School.class);
            StudentResponse studentResponse = new StudentResponse(student, school);
            return new ResponseEntity<>(studentResponse,HttpStatus.OK);
        } else{
            return new ResponseEntity<>("No Student Found",HttpStatus.NOT_FOUND);
        }
    }

}
