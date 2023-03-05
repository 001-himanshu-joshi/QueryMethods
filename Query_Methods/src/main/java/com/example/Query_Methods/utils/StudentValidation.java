package com.example.Query_Methods.utils;

import com.example.Query_Methods.dao.StudentRepository;
import com.example.Query_Methods.model.Student;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class StudentValidation {

    @Autowired
    StudentRepository studentRepository;
    public JSONObject validateStudent(String studentData){
        JSONObject jsonObject = new JSONObject(studentData);
        JSONObject responseObj = new JSONObject();
        if(jsonObject.has("firstName")){
            String providedFirstName = jsonObject.getString("firstName");
            List<Student> studentList = studentRepository.findByFirstName(providedFirstName);
            if(!studentList.isEmpty()){
                responseObj.put("ERROR", "Student already existed in database");
            }
        }else{
            responseObj.put("ERROR", "Enter correct First Name");
        }
        return responseObj;
    }

    public Student setStudent(JSONObject json) {
        Student newStudent = new Student();
        newStudent.setStudentId(json.getInt("studentId"));
        newStudent.setFirstName(json.getString("firstName"));
        newStudent.setLastName(json.getString("lastName"));
        newStudent.setActive(json.getBoolean("active"));
        newStudent.setAge(json.getInt("age"));
        newStudent.setAdmissionDate(new Timestamp(System.currentTimeMillis()));
        return newStudent;
    }
}
