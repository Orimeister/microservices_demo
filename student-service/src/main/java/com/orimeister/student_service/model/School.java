package com.orimeister.student_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class School {
    private Integer id;
    private String name;
    private String location;
    private String principalName;
}
