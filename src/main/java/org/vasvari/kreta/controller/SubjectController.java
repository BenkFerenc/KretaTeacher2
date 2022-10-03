package org.vasvari.kreta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.vasvari.kreta.model.Subject;
import org.vasvari.kreta.service.SubjectService;

import java.util.List;

@Controller
public class SubjectController {
    @Autowired
    SubjectService service;
    @GetMapping("/subjects/index")
    public ModelAndView showSubjectList()
    {
        List<Subject> subjects = service.getAllSubjects();
        ModelAndView mav=new ModelAndView("subjects/index");
        mav.addObject("subjects",subjects);

        return mav;


    }


}
