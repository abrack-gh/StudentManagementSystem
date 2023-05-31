package com.sms.studentmanagementsystem.Controller;

import com.sms.studentmanagementsystem.Repository.TeacherRepository;
import com.sms.studentmanagementsystem.Service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeacherController {

    private TeacherService teacherService;
    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherService teacherService, TeacherRepository teacherRepository) {
        super();
        this.teacherService = teacherService;
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/teachers")
    public String listTeachers(Model model){

        model.addAttribute("teachers", teacherService.getAllTeachers());

        return "teachers";
    }
}
