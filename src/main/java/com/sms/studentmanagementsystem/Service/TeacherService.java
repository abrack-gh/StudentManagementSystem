package com.sms.studentmanagementsystem.Service;

import com.sms.studentmanagementsystem.Entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    List<Teacher> getAllTeachers();

    Teacher saveTeacher(Teacher teacher);

    Teacher getTeacherById(Long id);

    Teacher editTeacher(Teacher teacher);

    void deleteTeacher(Long id);

}
