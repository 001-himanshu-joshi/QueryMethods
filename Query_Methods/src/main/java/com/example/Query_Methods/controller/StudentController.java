package com.example.Query_Methods.controller;

import com.example.Query_Methods.model.Student;
import com.example.Query_Methods.service.StudentService;
import com.example.Query_Methods.utils.StudentValidation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    StudentValidation studentValidation;
    @Autowired
    StudentService studentService;

    @PostMapping("/postStudent")
    public ResponseEntity saveStudent(@RequestBody String studentData){
        JSONObject json = studentValidation.validateStudent(studentData);
        if(!json.isEmpty()){
            if(json.has("ERROR")){
                return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
            }
            Student student = studentValidation.setStudent(json);
            return  new ResponseEntity<>("Student is saved with name " + studentService.postStudent(student), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getStudentByFirstName")
    public ResponseEntity getByFirstName(@RequestParam String firstName){
        return new ResponseEntity<>(studentService.getStudentByFirstName(firstName), HttpStatus.OK);
    }

    @GetMapping("getStudentByLastName")
    public ResponseEntity getByLastName(@RequestParam String lastName){
        return new ResponseEntity<>(studentService.getStudentByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping("getStudentByAge")
    public ResponseEntity getByAge(@RequestParam String age){
        return new ResponseEntity<>(studentService.getStudentByAge(age), HttpStatus.OK);
    }

    @GetMapping("getStudentByActiveness")
    public ResponseEntity getByActive(@RequestParam Boolean active){
        return new ResponseEntity<>(studentService.getStudentByActiveness(active), HttpStatus.OK);
    }
}
