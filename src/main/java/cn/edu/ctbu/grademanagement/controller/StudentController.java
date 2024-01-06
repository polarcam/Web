package cn.edu.ctbu.grademanagement.controller;


import cn.edu.ctbu.grademanagement.core.PageUtils;
import cn.edu.ctbu.grademanagement.domain.*;
import cn.edu.ctbu.grademanagement.exception.REnum;
import cn.edu.ctbu.grademanagement.exception.RException;
import cn.edu.ctbu.grademanagement.service.CourseService.CourseService;
import cn.edu.ctbu.grademanagement.service.SelectCourseService.SelectCourseService;
import cn.edu.ctbu.grademanagement.service.StudentCourseMessageService.StudentCourseMessageService;
import cn.edu.ctbu.grademanagement.service.StudentSelectCourseService.StudentSelectCourseService;
import cn.edu.ctbu.grademanagement.service.StudentService.StudentService;
import cn.edu.ctbu.grademanagement.vo.StudentCourseMessage;
import cn.edu.ctbu.grademanagement.vo.StudentSelectCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StudentController {
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

    /**
     * 页面跳转
     * @return
     */
    @RequestMapping("/student/studentList.html")
    public String studentListDisplay(){return "student/studentList";}
    @RequestMapping("/student/studentSelectCourse.html")
    public String studentSelectCourseDisplay(){return "student/studentSelectCourse";}
    @RequestMapping("/student/loginScreen.html")
    public String administratorLoginScreen(){return "login/loginScreen";}


    /**
     * 用于显示页面左上角的名字
     * @param httpServletRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/student/showName")
    public String studentName(HttpServletRequest httpServletRequest) throws Exception{
        HttpSession session = httpServletRequest.getSession();
        if (!session.getAttribute("choose").equals("1") || session.getAttribute("userid") == null){
            throw new RException(REnum.LOGIN_ERR);
        }
        Student studentMessage = (Student) session.getAttribute("user");
        return studentMessage.getSname();
    }

    /**
     * 完成成绩查询里的查询功能
     * @param size
     * @param pageNum
     * @param name
     * @param httpServletRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/student/search")
    public PageUtils studentSearch(@RequestParam(value = "size",defaultValue = "10") Integer size,
                                   @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                   @RequestParam(value = "name",defaultValue = "") String name,
                                   HttpServletRequest httpServletRequest) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        if (!session.getAttribute("choose").equals("1") || session.getAttribute("userid") == null){
            throw new RException(REnum.LOGIN_ERR);
        }
        String[] arrayList = name.split("!");

        name = arrayList[0];
        String searchOption = arrayList[1];
        String searchMatching = arrayList[2];

        List<StudentCourseMessage> studentCourseMessages = new ArrayList<>();

        PageUtils allStudentList = studentGetByPage(0, 2000000000, 1, httpServletRequest);

        if (searchMatching.equals("20")) {//模糊查询
            if (searchOption.equals("10")) {//课号查询
                studentCourseMessages = studentCourseMessageService.findByCnoLike(name, (List<StudentCourseMessage>) allStudentList.getRows());
            } else if (searchOption.equals("11")) {//以课程名查询
                studentCourseMessages = studentCourseMessageService.findByCnameLike(name, (List<StudentCourseMessage>) allStudentList.getRows());
            } else if (searchOption.equals("12")) {//以课时查询
                studentCourseMessages = studentCourseMessageService.findByHourLike(Integer.parseInt(name), (List<StudentCourseMessage>) allStudentList.getRows());
            } else if (searchOption.equals("13")) {//以成绩名查询
                studentCourseMessages = studentCourseMessageService.findByScoreLike(Integer.parseInt(name), (List<StudentCourseMessage>) allStudentList.getRows());
            } else {//以学分查询
                studentCourseMessages = studentCourseMessageService.findByCreditLike(Float.parseFloat(name), (List<StudentCourseMessage>) allStudentList.getRows());
            }
        } else {//精确查询
            if (searchOption.equals("10")) {//课号查询
                studentCourseMessages = studentCourseMessageService.findByCno(name, (List<StudentCourseMessage>) allStudentList.getRows());
            } else if (searchOption.equals("11")) {//以课程名查询
                studentCourseMessages = studentCourseMessageService.findByCname(name, (List<StudentCourseMessage>) allStudentList.getRows());
            } else if (searchOption.equals("12")) {//以课时查询
                studentCourseMessages = studentCourseMessageService.findByHour(Integer.parseInt(name), (List<StudentCourseMessage>) allStudentList.getRows());
            } else if (searchOption.equals("13")) {//以成绩名查询
                studentCourseMessages = studentCourseMessageService.findByScore(Integer.parseInt(name), (List<StudentCourseMessage>) allStudentList.getRows());
            }  else {//以学分查询
                studentCourseMessages = studentCourseMessageService.findByCredit(Float.parseFloat(name), (List<StudentCourseMessage>) allStudentList.getRows());
            }
        }
        int studentCourseMessagesSize = studentCourseMessages.size();
        studentCourseMessages = studentCourseMessages.stream().skip((pageNum - 1) * size).limit(size).collect(Collectors.toList());
        PageUtils pageUtils = new PageUtils(studentCourseMessages, studentCourseMessagesSize);

        return pageUtils;
    }

    /**
     * 用于成绩查询里的总览表
     * @param page
     * @param size
     * @param pageNum
     * @param httpServletRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/student/displayList")
    public PageUtils studentGetByPage(@RequestParam(value = "page",defaultValue = "0") Integer page,
                               @RequestParam(value = "size",defaultValue = "10") Integer size,
                               @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                               HttpServletRequest httpServletRequest) throws Exception{
        HttpSession session = httpServletRequest.getSession();
        if (!session.getAttribute("choose").equals("1") || session.getAttribute("userid") == null){
            throw new RException(REnum.LOGIN_ERR);
        }
        //序号，课号，课名，课时，学分，分数
        Student studentMessage = (Student) session.getAttribute("user");
        List<SelectCourse> studentSelectCourse = selectCourseService.findBySno(studentMessage.getSno());
        List<StudentCourseMessage> studentCourseMessages = new ArrayList<>();

        for (int i = 0;i < studentSelectCourse.size();i++){
            StudentCourseMessage studentCourseMessage = new StudentCourseMessage();
            studentCourseMessage.setId(i+1);
            studentCourseMessage.setScore(studentSelectCourse.get(i).getScore());//设置学生成绩
            if (courseService.findByCno(studentSelectCourse.get(i).getCno()) != null){
                studentCourseMessage.setCname(courseService.findByCno(studentSelectCourse.get(i).getCno()).getCname());//设置课程名
                studentCourseMessage.setCredit(courseService.findByCno(studentSelectCourse.get(i).getCno()).getCredit());//设置学分
                studentCourseMessage.setHour(courseService.findByCno(studentSelectCourse.get(i).getCno()).getHour());//设置学时
                studentCourseMessage.setCno(studentSelectCourse.get(i).getCno());
            }
            studentCourseMessages.add(studentCourseMessage);
        }

        //设置分页
        int studentCourseMessagesSize = studentCourseMessages.size();
        studentCourseMessages = studentCourseMessages.stream().skip((pageNum-1)*size).limit(size).collect(Collectors.toList());
        PageUtils pageUtils = new PageUtils(studentCourseMessages,studentCourseMessagesSize);

        return pageUtils;
    }

    /**
     * 用于显示学生选课中的总览表
     * @param page
     * @param size
     * @param pageNum
     * @param httpServletRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/student/displaySelect")
    public PageUtils studentGetByPage_studentSelectCourse(@RequestParam(value = "page",defaultValue = "0") Integer page,
                                                          @RequestParam(value = "size",defaultValue = "10") Integer size,
                                                          @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                          HttpServletRequest httpServletRequest) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        if (!session.getAttribute("choose").equals("1") || session.getAttribute("userid") == null) {
            throw new RException(REnum.LOGIN_ERR);
        }
        //序号，课号，课名，课时，学分，是否选择了这门课
        List<StudentCourseMessage> allStudentList = (List<StudentCourseMessage>) studentGetByPage(0, 2000000000, 1, httpServletRequest).getRows();
        List<StudentSelectCourse> studentSelectCourses = new ArrayList<>();
        List<Course> courses = courseService.findAll();

        for (int i = 0; i < courses.size(); i++) {
            StudentSelectCourse studentSelectCourse = new StudentSelectCourse();
            studentSelectCourse.setId(i);
            studentSelectCourse.setCno(courses.get(i).getCno());
            studentSelectCourse.setCname(courses.get(i).getCname());
            studentSelectCourse.setHour(courses.get(i).getHour());
            studentSelectCourse.setCredit(courses.get(i).getCredit());
            studentSelectCourse.setYesOrNo(0);
            for (int j = 0; j < allStudentList.size(); j++) {
                if (courses.get(i).getCno().equals(allStudentList.get(j).getCno())) {
                    studentSelectCourse.setYesOrNo(1);
                }
            }
            studentSelectCourses.add(studentSelectCourse);
        }


        //设置分页
        int studentSelectCoursesSize = studentSelectCourses.size();
        studentSelectCourses = studentSelectCourses.stream().skip((pageNum - 1) * size).limit(size).collect(Collectors.toList());
        PageUtils pageUtils = new PageUtils(studentSelectCourses, studentSelectCoursesSize);

        return pageUtils;
    }

    @ResponseBody
    @RequestMapping("/student/searchSelect")
    public PageUtils studentSearchSelect(@RequestParam(value = "size",defaultValue = "10") Integer size,
                                    @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                    @RequestParam(value = "name",defaultValue = "") String name,
                                    HttpServletRequest httpServletRequest) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        if (!session.getAttribute("choose").equals("1") || session.getAttribute("userid") == null){
            throw new RException(REnum.LOGIN_ERR);
        }
        String[] arrayList = name.split("!");

        name = arrayList[0];
        String searchOption = arrayList[1];
        String searchMatching = arrayList[2];

        List<StudentSelectCourse> studentSelectCourses = new ArrayList<>();

        PageUtils allStudentSelectCourse = studentGetByPage_studentSelectCourse(0, 2000000000, 1, httpServletRequest);

        if (searchMatching.equals("20")) {//模糊查询
            if (searchOption.equals("10")) {//课号查询
                studentSelectCourses = studentSelectCourseService.findByCnoLike(name, (List<StudentSelectCourse>) allStudentSelectCourse.getRows());
            } else if (searchOption.equals("11")) {//以课程名查询
                studentSelectCourses = studentSelectCourseService.findByCnameLike(name, (List<StudentSelectCourse>) allStudentSelectCourse.getRows());
            } else if (searchOption.equals("12")) {//以课时查询
                studentSelectCourses = studentSelectCourseService.findByHourLike(Integer.parseInt(name), (List<StudentSelectCourse>) allStudentSelectCourse.getRows());
            } else if (searchOption.equals("13")) {//学分
                studentSelectCourses = studentSelectCourseService.findByCreditLike(Float.parseFloat(name), (List<StudentSelectCourse>) allStudentSelectCourse.getRows());
            } else {//是否选课
                studentSelectCourses = studentSelectCourseService.findByYesOrNoLike(Integer.parseInt(name), (List<StudentSelectCourse>) allStudentSelectCourse.getRows());
            }
        } else {//精确查询
            if (searchOption.equals("10")) {//课号查询
                studentSelectCourses = studentSelectCourseService.findByCno(name, (List<StudentSelectCourse>) allStudentSelectCourse.getRows());
            } else if (searchOption.equals("11")) {//以课程名查询
                studentSelectCourses = studentSelectCourseService.findByCname(name, (List<StudentSelectCourse>) allStudentSelectCourse.getRows());
            } else if (searchOption.equals("12")) {//以课时查询
                studentSelectCourses = studentSelectCourseService.findByHour(Integer.parseInt(name), (List<StudentSelectCourse>) allStudentSelectCourse.getRows());
            } else if (searchOption.equals("13")) {//学分
                studentSelectCourses = studentSelectCourseService.findByCredit(Float.parseFloat(name), (List<StudentSelectCourse>) allStudentSelectCourse.getRows());
            } else {//是否选课
                studentSelectCourses = studentSelectCourseService.findByYesOrNo(Integer.parseInt(name), (List<StudentSelectCourse>) allStudentSelectCourse.getRows());
            }
        }
        //设置分页
        int studentCourseMessagesSize = studentSelectCourses.size();
        studentSelectCourses = studentSelectCourses.stream().skip((pageNum - 1) * size).limit(size).collect(Collectors.toList());
        PageUtils pageUtils = new PageUtils(studentSelectCourses, studentCourseMessagesSize);

        return pageUtils;

    }

    /**
     * 学生选课
     * @param cno
     * @param httpServletRequest
     */
    @ResponseBody
    @RequestMapping("/student/chooseCourse/{cno}")
    public void studentChooseCourse(@PathVariable String cno,HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        if (!session.getAttribute("choose").equals("1") || session.getAttribute("userid") == null) {
            throw new RException(REnum.LOGIN_ERR);
        }
        Student studentMessage = (Student) session.getAttribute("user");
        String studentSno = studentMessage.getSno();
        selectCourseService.insert(cno,studentSno);
    }

    /**
     * 学生退选
     * @param cno
     * @param httpServletRequest
     */
    @ResponseBody
    @RequestMapping("/student/unChooseCourse/{cno}")
    public void studentUnChooseCourse(@PathVariable String cno,HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        if (!session.getAttribute("choose").equals("1") || session.getAttribute("userid") == null) {
            throw new RException(REnum.LOGIN_ERR);
        }
        Student studentMessage = (Student) session.getAttribute("user");
        String studentSno = studentMessage.getSno();
        List<SelectCourse> selectCourses = selectCourseService.findAll();
        for (int i = 0;i < selectCourses.size();i++){
            if (selectCourses.get(i).getSno().equals(studentSno) && selectCourses.get(i).getCno().equals(cno)){
                selectCourseService.deleteId(selectCourses.get(i).getId());
            }
        }

    }

}


