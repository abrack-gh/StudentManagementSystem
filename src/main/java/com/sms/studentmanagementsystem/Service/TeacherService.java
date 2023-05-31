package com.sms.studentmanagementsystem.Service;

import com.sms.studentmanagementsystem.Entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    List<Teacher> getAllTeachers();

}
