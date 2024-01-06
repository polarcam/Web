package cn.edu.ctbu.grademanagement.StudentService;

import cn.edu.ctbu.grademanagement.domain.Student;
import cn.edu.ctbu.grademanagement.service.StudentService.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void findAll() {
        List<Student> students = studentService.findAll();
        assertNotNull(students);
    }

    @Test
    void findByName() {
    }

    @Test
    void findBySno() {
    }

    @Test
    void findByAge() {
    }

    @Test
    void findBySex() {
    }
}