package com.sms.studentmanagementsystem.Service.Impl;

import com.sms.studentmanagementsystem.Entity.Student;
import com.sms.studentmanagementsystem.Repository.StudentRepository;
import com.sms.studentmanagementsystem.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}
