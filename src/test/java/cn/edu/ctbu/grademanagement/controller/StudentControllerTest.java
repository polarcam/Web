package cn.edu.ctbu.grademanagement.controller;

import cn.edu.ctbu.grademanagement.core.PageUtils;
import cn.edu.ctbu.grademanagement.domain.SelectCourse;
import cn.edu.ctbu.grademanagement.exception.REnum;
import cn.edu.ctbu.grademanagement.exception.RException;
import cn.edu.ctbu.grademanagement.service.CourseService.CourseService;
import cn.edu.ctbu.grademanagement.service.SelectCourseService.SelectCourseService;
import cn.edu.ctbu.grademanagement.service.StudentService.StudentService;
import cn.edu.ctbu.grademanagement.domain.Student;

import cn.edu.ctbu.grademanagement.vo.StudentCourseMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentControllerTest {

    @Autowired
    private StudentService studentService;
    @Autowired
    private SelectCourseService selectCourseService;
    @Autowired
    private CourseService courseService;

    @Test
    void findAll() {
        List<Student> students = studentService.findAll();
        assertNotNull(students);
    }
}