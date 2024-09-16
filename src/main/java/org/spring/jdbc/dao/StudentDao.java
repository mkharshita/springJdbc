package org.spring.jdbc.dao;

import org.spring.jdbc.entities.Student;

import java.util.List;

public interface StudentDao {
    int insert(Student student);
    int change(Student student);
    int delete(int studentId);
    Student getStudent(int studentId);
    List<Student> getAllStudent();
}
