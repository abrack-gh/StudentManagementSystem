package com.sms.studentmanagementsystem.Service.Impl;

import com.sms.studentmanagementsystem.Entity.Teacher;
import com.sms.studentmanagementsystem.Repository.TeacherRepository;
import com.sms.studentmanagementsystem.Service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        super();
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}
