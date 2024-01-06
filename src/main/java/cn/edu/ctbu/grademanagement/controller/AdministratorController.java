package cn.edu.ctbu.grademanagement.controller;

import cn.edu.ctbu.grademanagement.core.PageUtils;
import cn.edu.ctbu.grademanagement.core.RUtil;
import cn.edu.ctbu.grademanagement.domain.*;
import cn.edu.ctbu.grademanagement.exception.REnum;
import cn.edu.ctbu.grademanagement.exception.RException;
import cn.edu.ctbu.grademanagement.service.AdministratorSelectCourseService.AdministratorSelectCourseService;
import cn.edu.ctbu.grademanagement.service.AdministratorService.AdministratorService;
import cn.edu.ctbu.grademanagement.service.CourseService.CourseService;
import cn.edu.ctbu.grademanagement.service.SelectCourseService.SelectCourseService;
import cn.edu.ctbu.grademanagement.service.StudentCourseMessageService.StudentCourseMessageService;
import cn.edu.ctbu.grademanagement.service.StudentSelectCourseService.StudentSelectCourseService;
import cn.edu.ctbu.grademanagement.service.StudentService.StudentService;
import cn.edu.ctbu.grademanagement.vo.AdministratorSelectCourse;
import cn.edu.ctbu.grademanagement.vo.R;
import cn.edu.ctbu.grademanagement.vo.StudentSelectCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AdministratorController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private SelectCourseService selectCourseService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentCourseMessageService studentCourseMessageService;
    @Autowired
    private StudentSelectCourseService studentSelectCourseService;
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private AdministratorSelectCourseService administratorSelectCourseService;

    @RequestMapping("/administrator/administratorListStudent.html")
    public String administratorListStudentDisplay() {
        return "administrator/administratorListStudent";
    }

    @RequestMapping("/administrator/administratorListCourse.html")
    public String administratorListCourseDisplay() {
        return "administrator/administratorListCourse";
    }

    @RequestMapping("/administrator/administratorListSelectCourse.html")
    public String administratorListSelectCourseDisplay() {
        return "administrator/administratorListSelectCourse";
    }

    @RequestMapping("/administrator/loginScreen.html")
    public String administratorLoginScreen() {
        return "login/loginScreen";
    }

    @ResponseBody
    @RequestMapping("/administrator/showName")
    public String administratorName(HttpServletRequest httpServletRequest) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        if (!session.getAttribute("choose").equals("2") || session.getAttribute("userid") == null) {
            throw new RException(REnum.LOGIN_ERR);
        }
        Administrator administratorMessage = (Administrator) session.getAttribute("user");
        return administratorMessage.getAname();
    }

    @ResponseBody
    @RequestMapping("/administrator/displayListStudent")
    public R administratorGetByPageStudent(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                           @RequestParam(value = "size", defaultValue = "10") Integer size,
                                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                           HttpServletRequest httpServletRequest) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        if (!session.getAttribute("choose").equals("2") || session.getAttribute("userid") == null) {
            throw new RException(REnum.LOGIN_ERR);
        }

        R<List<Student>> RStudents = studentService.findRAll();

        int RStudentsSize = RStudents.getData().size();
        RStudents.setData(RStudents.getData().stream().skip((pageNum - 1) * size).limit(size).collect(Collectors.toList()));
        PageUtils pageUtils = new PageUtils(RStudents.getData(), RStudentsSize);
        return RUtil.success(pageUtils);
    }

    @ResponseBody
    @RequestMapping("/administrator/searchStudent")
    public R administratorSearchStudent(@RequestParam(value = "size", defaultValue = "10") Integer size,
                                        @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                        @RequestParam(value = "name", defaultValue = "") String name,
                                        HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        if (!session.getAttribute("choose").equals("2") || session.getAttribute("userid") == null) {
            throw new RException(REnum.LOGIN_ERR);
        }

        String[] arrayList = name.split("!");

        name = arrayList[0];
        String searchOption = arrayList[1];
        String searchMatching = arrayList[2];


        R<List<Student>> studentMessageR = new R<>();
        List<Student> students = new ArrayList<>();

        if (searchMatching.equals("20")) {//模糊查询
            if (searchOption.equals("10")) {//学号
                studentMessageR.setData(studentService.findByRSnoLike(name).getData());
                studentMessageR.setCode(REnum.SUCCESS.getCode());
                studentMessageR.setMsg(REnum.SUCCESS.getMsg());
            } else if (searchOption.equals("11")) {//姓名
                studentMessageR.setData(studentService.findByRNameLike(name).getData());
                studentMessageR.setCode(REnum.SUCCESS.getCode());
                studentMessageR.setMsg(REnum.SUCCESS.getMsg());
            } else if (searchOption.equals("12")) {//性别
                studentMessageR.setData(studentService.findByRSexLike(name).getData());
                studentMessageR.setCode(REnum.SUCCESS.getCode());
                studentMessageR.setMsg(REnum.SUCCESS.getMsg());
            } else if (searchOption.equals("13")) {//年龄
                studentMessageR.setData(studentService.findByRAgeLike(Integer.parseInt(name)).getData());
                studentMessageR.setCode(REnum.SUCCESS.getCode());
                studentMessageR.setMsg(REnum.SUCCESS.getMsg());
            } else {//专业
                studentMessageR.setData(studentService.findByRDeptLike(name).getData());
                studentMessageR.setCode(REnum.SUCCESS.getCode());
                studentMessageR.setMsg(REnum.SUCCESS.getMsg());
            }
        } else {//精确查询
            if (searchOption.equals("10")) {//学号
                students.add(studentService.findByRSno(name).getData());
                if (students.get(0).getId() == null) {
                    students = new ArrayList<>();
                }
                studentMessageR.setData(students);
                studentMessageR.setCode(REnum.SUCCESS.getCode());
                studentMessageR.setMsg(REnum.SUCCESS.getMsg());
            } else if (searchOption.equals("11")) {//姓名
                studentMessageR.setData(studentService.findByRName(name).getData());
                studentMessageR.setCode(REnum.SUCCESS.getCode());
                studentMessageR.setMsg(REnum.SUCCESS.getMsg());
            } else if (searchOption.equals("12")) {//性别
                studentMessageR.setData(studentService.findByRSex(name).getData());
                studentMessageR.setCode(REnum.SUCCESS.getCode());
                studentMessageR.setMsg(REnum.SUCCESS.getMsg());
            } else if (searchOption.equals("13")) {//年龄
                studentMessageR.setData(studentService.findByRAge(Integer.parseInt(name)).getData());
                studentMessageR.setCode(REnum.SUCCESS.getCode());
                studentMessageR.setMsg(REnum.SUCCESS.getMsg());
            } else {//专业
                studentMessageR.setData(studentService.findByRDept(name).getData());
                studentMessageR.setCode(REnum.SUCCESS.getCode());
                studentMessageR.setMsg(REnum.SUCCESS.getMsg());
            }
        }

        int studentMessageRSize = studentMessageR.getData().size();
        studentMessageR.setData(studentMessageR.getData().stream().skip((pageNum - 1) * size).limit(size).collect(Collectors.toList()));
        PageUtils pageUtils = new PageUtils(studentMessageR.getData(), studentMessageRSize);
        return RUtil.success(pageUtils);
    }

    @ResponseBody
    @DeleteMapping("/administrator/deleteStudent/{sno}")
    public void delete(@PathVariable String sno) {
        R<List<SelectCourse>> selectCourseR = selectCourseService.findByRSno(sno);
        for (int i = 0; i < selectCourseR.getData().size(); i++) {
            selectCourseService.deleteId(selectCourseR.getData().get(i).getId());
        }
        studentService.deleteId(studentService.findByRSno(sno).getData().getId());
    }

    @ResponseBody
    @GetMapping("/administrator/getStudent/{sno}")
    public Student getStudent(@PathVariable String sno) {
        R<Student> studentR = studentService.findByRSno(sno);
        return studentR.getData();
    }

    @ResponseBody
    @PostMapping("administrator/insertStudent")
    public void insertStudent(Student student) {
        if (studentService.findByRSno(student.getSno()).getData().getSno() != null) {
            throw new RException(REnum.INSERTSTUDENT_ERR);
        }
        if (student.getSex().equals("1")) {
            student.setSex("男");
        } else {
            student.setSex("女");
        }
        studentService.insert(student);
    }

    @ResponseBody
    @PutMapping("administrator/updateStudent")
    public void updateStudent(Student student) {
        if (student.getSex().equals("1")) {
            student.setSex("男");
        } else {
            student.setSex("女");
        }
        studentService.update(student);
    }


    @ResponseBody
    @RequestMapping("/administrator/displayListCourse")
    public R administratorGetByPageCourse(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                          @RequestParam(value = "size", defaultValue = "10") Integer size,
                                          @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                          HttpServletRequest httpServletRequest) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        if (!session.getAttribute("choose").equals("2") || session.getAttribute("userid") == null) {
            throw new RException(REnum.LOGIN_ERR);
        }

        R<List<Course>> RCourse = courseService.findRAll();

        int RCourseSize = RCourse.getData().size();
        RCourse.setData(RCourse.getData().stream().skip((pageNum - 1) * size).limit(size).collect(Collectors.toList()));
        PageUtils pageUtils = new PageUtils(RCourse.getData(), RCourseSize);
        return RUtil.success(pageUtils);
    }

    @ResponseBody
    @RequestMapping("/administrator/searchCourse")
    public R administratorSearchCourse(@RequestParam(value = "size", defaultValue = "10") Integer size,
                                       @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                       @RequestParam(value = "name", defaultValue = "") String name,
                                       HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        if (!session.getAttribute("choose").equals("2") || session.getAttribute("userid") == null) {
            throw new RException(REnum.LOGIN_ERR);
        }

        String[] arrayList = name.split("!");

        name = arrayList[0];
        String searchOption = arrayList[1];
        String searchMatching = arrayList[2];


        R<List<Course>> courseMessageR = new R<>();
        List<Course> courses = new ArrayList<>();

        if (searchMatching.equals("20")) {//模糊查询
            if (searchOption.equals("10")) {//课号
                courseMessageR.setData(courseService.findByRCnoLike(name).getData());
                courseMessageR.setCode(REnum.SUCCESS.getCode());
                courseMessageR.setMsg(REnum.SUCCESS.getMsg());
            } else if (searchOption.equals("11")) {//课名
                courseMessageR.setData(courseService.findByRNameLike(name).getData());
                courseMessageR.setCode(REnum.SUCCESS.getCode());
                courseMessageR.setMsg(REnum.SUCCESS.getMsg());
            } else if (searchOption.equals("12")) {//课时
                courseMessageR.setData(courseService.findByRHourLike(Integer.parseInt(name)).getData());
                courseMessageR.setCode(REnum.SUCCESS.getCode());
                courseMessageR.setMsg(REnum.SUCCESS.getMsg());
            } else {//学分
                courseMessageR.setData(courseService.findByRCreditLike(Float.parseFloat(name)).getData());
                courseMessageR.setCode(REnum.SUCCESS.getCode());
                courseMessageR.setMsg(REnum.SUCCESS.getMsg());
            }
        } else {//精确查询
            if (searchOption.equals("10")) {//课号
                courses.add(courseService.findByRCno(name).getData());
                if (courses.get(0).getId() == null) {
                    courses = new ArrayList<>();
                }
                courseMessageR.setData(courses);
                courseMessageR.setCode(REnum.SUCCESS.getCode());
                courseMessageR.setMsg(REnum.SUCCESS.getMsg());
            } else if (searchOption.equals("11")) {//课名
                courseMessageR.setData(courseService.findByRName(name).getData());
                courseMessageR.setCode(REnum.SUCCESS.getCode());
                courseMessageR.setMsg(REnum.SUCCESS.getMsg());
            } else if (searchOption.equals("12")) {//课时
                courseMessageR.setData(courseService.findByRHour(Integer.parseInt(name)).getData());
                courseMessageR.setCode(REnum.SUCCESS.getCode());
                courseMessageR.setMsg(REnum.SUCCESS.getMsg());
            } else {//学分
                courseMessageR.setData(courseService.findByRCredit(Float.parseFloat(name)).getData());
                courseMessageR.setCode(REnum.SUCCESS.getCode());
                courseMessageR.setMsg(REnum.SUCCESS.getMsg());
            }
        }

        int courseMessageRSize = courseMessageR.getData().size();
        courseMessageR.setData(courseMessageR.getData().stream().skip((pageNum - 1) * size).limit(size).collect(Collectors.toList()));
        PageUtils pageUtils = new PageUtils(courseMessageR.getData(), courseMessageRSize);
        return RUtil.success(pageUtils);
    }


    @ResponseBody
    @GetMapping("/administrator/getCourse/{cno}")
    public Course getCourse(@PathVariable String cno) {
        R<Course> courseR = courseService.findByRCno(cno);
        return courseR.getData();
    }

    @ResponseBody
    @PostMapping("administrator/insertCourse")
    public void insertCourse(Course course) throws RException {
        if (courseService.findByRCno(course.getCno()).getData().getCno() != null) {
            throw new RException(REnum.INSERTCOURSE_ERR);
        }
        courseService.insert(course);
    }

    @ResponseBody
    @PutMapping("administrator/updateCourse")
    public void updateCourse(Course course) {

        courseService.update(course);
    }


    @ResponseBody
    @DeleteMapping("/administrator/deleteSelectCourse/{snoAndCno}")
    public void deleteSelectCourse(@PathVariable String snoAndCno) {
        String[] arrayList = snoAndCno.split("!");
        String sno = arrayList[0];
        String cno = arrayList[1];

        for (int i = 0; i < selectCourseService.findByRCnoAndSno(cno, sno).getData().size(); i++) {
            selectCourseService.deleteId(selectCourseService.findByRCnoAndSno(cno, sno).getData().get(0).getId());
        }

    }

    @ResponseBody
    @GetMapping("/administrator/getSelectCourse/{snoAndCno}")
    public SelectCourse getSelectCourse(@PathVariable String snoAndCno) {
        String[] arrayList = snoAndCno.split("!");
        String sno = arrayList[0];
        String cno = arrayList[1];
        R<SelectCourse> selectCourseR = new R<>();
        selectCourseR.setData(selectCourseService.findByRCnoAndSno(cno, sno).getData().get(0));
        selectCourseR.setCode(REnum.SUCCESS.getCode());
        selectCourseR.setMsg(REnum.SUCCESS.getMsg());

        return selectCourseR.getData();
    }

    @ResponseBody
    @PostMapping("administrator/insertSelectCourse")
    public void insertSelectCourse(SelectCourse selectCourse) throws RException {
        if (studentService.findByRSno(selectCourse.getSno()).getData().getId() == null || courseService.findByRCno(selectCourse.getCno()).getData().getId() == null) {
            RException rException = new RException(REnum.SEARCH_ERR);
            throw rException;
        } else if (selectCourseService.findByRCnoAndSno(selectCourse.getCno(), selectCourse.getSno()).getData().size() > 0) {
            RException rException = new RException(REnum.DATA_ERR);
            throw rException;
        } else {
            selectCourseService.insert(selectCourse);
        }

    }
}
