package com.example.Query_Methods.service;

import com.example.Query_Methods.dao.StudentRepository;
import com.example.Query_Methods.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    
    @Autowired
    StudentRepository studentRepository;


    public String postStudent(Student student) {
        Student newStudent = studentRepository.save(student);
        return newStudent.getFirstName() + " " + newStudent.getLastName();
    }

    public List<Student> getStudentByFirstName(String firstName) {
        List<Student> studentList = studentRepository.findByFirstName(firstName);
        return studentList;
    }

    public List<Student> getStudentByLastName(String lastName) {
        List<Student> studentList = studentRepository.findByLastName(lastName);
        return studentList;
    }

    public List<Student> getStudentByAge(String age) {
        List<Student> studentList = studentRepository.findByAge(Integer.valueOf(age));
        return studentList;
    }

    public List<Student> getStudentByActiveness(Boolean active) {
        List<Student> studentList = studentRepository.findByActive(active);
        return studentList;
    }
}
