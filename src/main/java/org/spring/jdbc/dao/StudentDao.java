package org.spring.jdbc.dao;

import org.spring.jdbc.entities.Student;

public interface StudentDao {
    int insert(Student student);
    int change(Student student);
    int delete(int studentId);
}
