package org.spring.jdbcAnnotation.dao;

import org.spring.jdbcAnnotation.entities.Student;

import java.util.List;

public interface StudentDao {
    int insert(Student student);
    int change(Student student);
    int delete(int studentId);
    Student getStudent(int studentId);
    List<Student> getAllStudent();
}
