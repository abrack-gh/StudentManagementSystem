package com.sms.studentmanagementsystem;

import com.sms.studentmanagementsystem.Entity.Student;
import com.sms.studentmanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);

    }

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void run(String... args) throws Exception {

        Student student1 = new Student();
        student1.setFirstName("Alex");
        student1.setLastName("Brack");
        student1.setEmail("a.brack@live.co.uk");

        studentRepository.save(student1);

    }
}
