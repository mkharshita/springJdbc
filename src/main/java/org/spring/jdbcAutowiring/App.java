package org.spring.jdbcAutowiring;

import org.spring.jdbcAutowiring.dao.StudentDao;
import org.spring.jdbcAutowiring.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program Started......." );
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(jdbcConfig.class);

        StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);

        Student student = new Student(105,"Yash Saxena","Kolkata");

        //int result = studentDao.insert(student);

        //System.out.println("Student Added : " + result);

//        int result = studentDao.change(student);
//
//        System.out.println("Student Updated : " + result);

//        int result = studentDao.delete(student.getId());
//
//        System.out.println("Student Deleted : " + result);

//        Student student1 = studentDao.getStudent(101);
//        System.out.println("Student Details : " + student1);

        List<Student> students = studentDao.getAllStudent();
        for (Student student1 : students){
            System.out.println(student1);
        }

    }

    public void withQuery(ApplicationContext applicationContext){
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        String query = "insert into student(id,name,city) values(?,?,?)";

        int update = jdbcTemplate.update(query, 104, "Akshara Saxena", "Noida");

        System.out.println("no. of records inserted : " + update);
    }
}
