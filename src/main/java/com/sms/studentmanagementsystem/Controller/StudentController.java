package com.sms.studentmanagementsystem.Controller;

import com.sms.studentmanagementsystem.Entity.Student;
import com.sms.studentmanagementsystem.Service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model model){

        model.addAttribute("students", studentService.getAllStudents());

        return "students";
    }

    @GetMapping("/students/new")
    public String addStudents(Model model){

        Student student = new Student();
        model.addAttribute("student", student);

        return "new_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){

        studentService.saveStudent(student);

        return "redirect:/students";

    }

}
