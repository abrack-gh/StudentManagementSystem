package com.sms.studentmanagementsystem.Controller;

import com.sms.studentmanagementsystem.Service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentController {
    private StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model){

        model.addAttribute("students", studentService.getAllStudents());

        return "students";

    }

}
