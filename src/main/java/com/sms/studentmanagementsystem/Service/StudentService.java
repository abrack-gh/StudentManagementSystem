package com.sms.studentmanagementsystem.Service;

import com.sms.studentmanagementsystem.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student editStudent(Student student);


}
