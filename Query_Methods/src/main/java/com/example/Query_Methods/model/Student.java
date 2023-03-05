package com.example.Query_Methods.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "student_table")
public class Student {

    @Id
    @Column(name = "studentId")
    private int studentId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "age")
    private Integer age ;
    @Column(name = "active")
    private Boolean active ;
    @Column(name = "admissionDate")
    private Date admissionDate;
}
