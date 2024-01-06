package cn.edu.ctbu.grademanagement.service.StudentService.impl;

import cn.edu.ctbu.grademanagement.domain.Student;
import cn.edu.ctbu.grademanagement.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentImplServiceTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void insert() {
        Student student = new Student();
        student.setAge(1);
        student.setSno("2020413318");
        student.setSname("赵六");
        student.setSex("男");
        student.setPassword("abcdef");
        studentRepository.save(student);
    }

    @Test
    void update() {
        Student student = new Student();
        student.setAge(23);
        student.setSno("2020413318");
        student.setSname("赵六");
        student.setSex("男");
        student.setPassword("abcdef");
        student.setId(2);
        studentRepository.save(student);
    }

    @Test
    void deleteId() {
        Integer id = 2;
        studentRepository.deleteById(id);
    }
}