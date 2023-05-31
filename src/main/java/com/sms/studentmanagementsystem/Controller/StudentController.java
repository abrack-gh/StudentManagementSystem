package com.sms.studentmanagementsystem.Controller;

import com.sms.studentmanagementsystem.Entity.Student;
import com.sms.studentmanagementsystem.Repository.StudentRepository;
import com.sms.studentmanagementsystem.Service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private StudentService studentService;
    private final StudentRepository studentRepository;

    public StudentController(StudentService studentService,
                             StudentRepository studentRepository) {
        super();
        this.studentService = studentService;
        this.studentRepository = studentRepository;
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

    @GetMapping("/students/edit/{id}")
    public String updateStudent(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String modifyStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model){

        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentRepository.save(existingStudent);

        return "redirect:/students";

    }

}
