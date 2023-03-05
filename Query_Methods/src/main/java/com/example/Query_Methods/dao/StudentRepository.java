package com.example.Query_Methods.dao;

import com.example.Query_Methods.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "Select * from student_table where first_name = :firstName", nativeQuery = true)
    public List<Student> findByFirstName(String firstName);
    @Query(value = "Select * from student_table where last_name = :lastName", nativeQuery = true)
    public List<Student> findByLastName(String lastName);

    @Query(value = "Select * from student_table where age = :age", nativeQuery = true)
    public List<Student> findByAge(Integer age);

    @Query(value = "Select * from student_table where active = :active", nativeQuery = true)
    public List<Student> findByActive(Boolean active);

}
