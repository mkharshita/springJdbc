package org.spring.jdbc;

import org.spring.jdbc.dao.StudentDao;
import org.spring.jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program Started......." );
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");

        StudentDao studentDao = applicationContext.getBean("studentDao",StudentDao.class);

        Student student = new Student(105,"Yash Saxena","Kolkata");

        //int result = studentDao.insert(student);

        //System.out.println("Student Added : " + result);

//        int result = studentDao.change(student);
//
//        System.out.println("Student Updated : " + result);

        int result = studentDao.delete(student.getId());

        System.out.println("Student Deleted : " + result);

    }

    public void withQuery(ApplicationContext applicationContext){
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        String query = "insert into student(id,name,city) values(?,?,?)";

        int update = jdbcTemplate.update(query, 104, "Akshara Saxena", "Noida");

        System.out.println("no. of records inserted : " + update);
    }
}
