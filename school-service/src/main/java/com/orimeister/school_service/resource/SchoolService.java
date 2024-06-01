package com.orimeister.school_service.resource;


import com.orimeister.school_service.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public List<School> findAllSchools(){
        return schoolRepository.findAll();
    }
    public Optional<School> findSchool(Integer id){
        return schoolRepository.findById(id);
    }
    public School addSchool(School school){
        return schoolRepository.save(school);
    }
    public boolean deleteSchool(Integer id){
        if(schoolRepository.existsById(id)){
            schoolRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
