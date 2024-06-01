package com.orimeister.school_service.resource;

import com.orimeister.school_service.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public School addSchool(@RequestBody School school){
        return schoolService.addSchool(school);
    }

    @GetMapping
    public List<School> getAllSchools(){
        return schoolService.findAllSchools();
    }
    @GetMapping("/{id}")
    public School getSchoolById(@PathVariable Integer id){
        return schoolService.findSchool(id).orElse(null);
    }
    @DeleteMapping("/{id}")
    public boolean deleteSchool(Integer id){
        return schoolService.deleteSchool(id);
    }

}
