package com.sms.studentmanagementsystem.Controller;

import com.sms.studentmanagementsystem.Entity.Student;
import com.sms.studentmanagementsystem.Entity.Teacher;
import com.sms.studentmanagementsystem.Repository.TeacherRepository;
import com.sms.studentmanagementsystem.Service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/teachers/new")
    public String addTeachers(Model model){

        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);

        return "new_teacher";
    }

    @PostMapping("/teachers")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher){

        teacherService.saveTeacher(teacher);

        return "redirect:/teachers";
    }

    @GetMapping("/teachers/edit/{id}")
    public String getTeacherById(@PathVariable Long id, Model model){

        model.addAttribute("teacher", teacherService.getTeacherById(id));

        return "edit_teacher";
    }

    @PostMapping("/teachers/{id}")
    public String modifyTeacher(@PathVariable Long id,
                                @ModelAttribute("teacher") Student student,
                                Model model){

        Teacher existingTeacher = teacherService.getTeacherById(id);
        existingTeacher.setFirstName(existingTeacher.getFirstName());
        existingTeacher.setLastName(existingTeacher.getLastName());
        existingTeacher.setEmail(existingTeacher.getEmail());
        existingTeacher.setSubject(existingTeacher.getSubject());

        teacherRepository.save(existingTeacher);

        return "redirect:/teachers";

    }

    @GetMapping("/teachers/{id}")
    public String deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacher(id);

        return "redirect:/teachers";
    }

}
