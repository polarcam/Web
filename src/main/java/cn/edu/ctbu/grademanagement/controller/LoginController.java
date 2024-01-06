package cn.edu.ctbu.grademanagement.controller;

import cn.edu.ctbu.grademanagement.domain.Administrator;
import cn.edu.ctbu.grademanagement.domain.Student;
import cn.edu.ctbu.grademanagement.service.AdministratorService.AdministratorService;
import cn.edu.ctbu.grademanagement.service.StudentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    StudentService studentService;
    @Autowired
    AdministratorService administratorService;

    /**
     * 登录界面
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login/loginScreen";
    }

    /**
     * 查看学生列表
     *
     * @param httpServletRequest
     * @param model
     * @return
     */
    @RequestMapping("/student/studentScreen")
    public String list(HttpServletRequest httpServletRequest, Model model) {
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("userid") == null) {
            return "redirect:/login";
        }
        List<Student> students = studentService.findAll();
        model.addAttribute("data", students);
        return "student/studentScreen";
    }

    @RequestMapping("/administrator/administratorScreen")
    public String administratorList(HttpServletRequest httpServletRequest, Model model) {
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("userid") == null) {
            return "redirect:/login";
        }
        List<Administrator> administrators = administratorService.findAll();
        model.addAttribute("data", administrators);
        return "administrator/administratorScreen";
    }

    /**
     * 登录检查
     *
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping("/loginCheck")
    public int loginCheck(HttpServletRequest httpServletRequest, String username, String password, String choose) {
        if (choose.equals("1")) {
            Student student = studentService.findBySnoAndPassword(username, password);
            if (student.getId() != null) {
                HttpSession session = httpServletRequest.getSession();
                session.setAttribute("userid", student.getId());
                session.setAttribute("user", student);
                session.setAttribute("choose", choose);
                return 1;
            } else {
                return -1;
            }
        } else if (choose.equals("2")) {
            Administrator administrator = administratorService.findByAnoAndPassword(username,password);
            if (administrator.getId() != null){
                HttpSession session = httpServletRequest.getSession();
                session.setAttribute("userid",administrator.getId());
                session.setAttribute("user",administrator);
                session.setAttribute("choose",choose);
                return 2;
            }else{
                return -1;
            }
        } else{
            return -1;
        }
    }

}