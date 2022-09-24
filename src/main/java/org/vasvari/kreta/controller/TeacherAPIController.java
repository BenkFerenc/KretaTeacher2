package org.vasvari.kreta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vasvari.kreta.model.Teacher;
import org.vasvari.kreta.service.TeacherServices;

import java.util.List;

@RestController
public class TeacherAPIController {
//kommentelni mindent
    @Autowired
    TeacherServices service;

    @GetMapping(value = "/api/teacher", name = "List of all teacher.")
    public List<Teacher> getAllSubjects() {
        return service.getAllSubjects();
    }

    @PostMapping(value = "/api/teacher", name= "Save teacher")
    public long saveTeacher(@RequestBody Teacher teacher){
        service.saveOrUpdate(teacher);
        return teacher.getId();
    }

    @PutMapping(value = "/api/teacher",name="Update teacher")
    private Teacher update(@RequestBody Teacher teacher) {
        service.saveOrUpdate(teacher);
        return teacher;
    }

    @DeleteMapping(value="/api/teacher/{teacherid}",name = "Delete Teacher")
    private void deleteSubject(@PathVariable("teacherid") Long teacherid) {
        service.delete(teacherid);
    }




}
