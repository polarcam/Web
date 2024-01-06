package cn.edu.ctbu.grademanagement.service.CourseService.impl;

import cn.edu.ctbu.grademanagement.domain.Course;
import cn.edu.ctbu.grademanagement.exception.REnum;
import cn.edu.ctbu.grademanagement.repository.CourseRepository;
import cn.edu.ctbu.grademanagement.service.CourseService.CourseService;
import cn.edu.ctbu.grademanagement.vo.R;
import cn.edu.ctbu.grademanagement.vo.StudentCourseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseImplService implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll(){
        return courseRepository.findAll();
    }
    public R<List<Course>> findRAll(){
        R<List<Course>> RAll = new R<>();
        RAll.setData(courseRepository.findAll());
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }

    /**
     * 以课名查询课程
     * @param name
     * @return 返回List
     */
    public List<Course> findByName(String name){
        List<Course> course = courseRepository.findAll();
        List<Course> courseNew = new ArrayList<>();
        for (int i = 0;i < course.size();i++){
            if (name.equals(course.get(i).getCname())){
                courseNew.add(course.get(i));
            }
        }
        return courseNew;
    }

    public R<List<Course>> findByRName(String name){
        List<Course> course = courseRepository.findAll();
        List<Course> courseNew = new ArrayList<>();
        for (int i = 0;i < course.size();i++){
            if (name.equals(course.get(i).getCname())){
                courseNew.add(course.get(i));
            }
        }
        R<List<Course>> RAll = new R<>();
        RAll.setData(courseNew);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }

    public R<List<Course>> findByRNameLike(String name){
        List<Course> course = courseRepository.findAll();
        List<Course> courseNew = new ArrayList<>();
        for (int i = 0;i < course.size();i++){
            if (course.get(i).getCname().indexOf(name) >= 0){
                courseNew.add(course.get(i));
            }
        }
        R<List<Course>> RAll = new R<>();
        RAll.setData(courseNew);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }
    /**
     * 以课号查询课程
     * @param Cno
     * @return 返回Course
     */
    public Course findByCno(String Cno){
        List<Course> course = courseRepository.findAll();
        Course courses = new Course();
        for (int i = 0;i < course.size();i++){
            if (Cno.equals(course.get(i).getCno())){
                courses = course.get(i);
            }
        }
        return courses;
    }
    public R<Course> findByRCno(String cno){
        List<Course> course = courseRepository.findAll();
        Course courses = new Course();
        for (int i = 0;i < course.size();i++){
            if (cno.equals(course.get(i).getCno())){
                courses = course.get(i);
            }
        }
        R<Course> RAll = new R<>();
        RAll.setData(courses);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }
    public R<List<Course>> findByRCnoLike(String cno){
        List<Course> course = courseRepository.findAll();
        List<Course> courses = new ArrayList<>();
        for (int i = 0;i < course.size();i++){
            if (course.get(i).getCno().indexOf(cno) >= 0){
                courses.add(course.get(i));
            }
        }
        R<List<Course>> RAll = new R<>();
        RAll.setData(courses);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }


    /**
     * 课程信息的增加
     * @param course
     * @return 返回Course
     */
    public Course insert(Course course){
        courseRepository.save(course);
        return course;
    }

    /**
     * 课程信息的更新
     * @param course
     * @return
     */
    public Course update(Course course){
        courseRepository.save(course);
        return course;
    }

    /**
     * 课程信息通过id删除
     * @param id
     */
    public void deleteId(Integer id){
        courseRepository.deleteById(id);
    }


    public List<Course> findByHour(Integer hour){
        List<Course> courses = courseRepository.findAll();
        List<Course> coursesNew = new ArrayList<>();
        for (int i = 0;i < courses.size();i++){
            if (hour == courses.get(i).getHour()){
                coursesNew.add(courses.get(i));
            }
        }
        return coursesNew;
    }
    public R<List<Course>> findByRHour(Integer hour){
        List<Course> courses = courseRepository.findAll();
        List<Course> coursesNew = new ArrayList<>();
        for (int i = 0;i < courses.size();i++){
            if (hour == courses.get(i).getHour()){
                coursesNew.add(courses.get(i));
            }
        }
        R<List<Course>> RAll = new R<>();
        RAll.setData(coursesNew);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }
    public R<List<Course>> findByRHourLike(Integer hour){
        List<Course> course = courseRepository.findAll();
        List<Course> coursesNew= new ArrayList<>();
        for (int i = 0;i < course.size();i++){
            if (String.valueOf(course.get(i).getHour()).indexOf(String.valueOf(hour)) >= 0){
                coursesNew.add(course.get(i));
            }
        }
        R<List<Course>> RAll = new R<>();
        RAll.setData(coursesNew);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }

    public List<Course> findByCredit(float credit){
        List<Course> courses = courseRepository.findAll();
        List<Course> coursesNew = new ArrayList<>();
        for (int i = 0;i < courses.size();i++){
            if (credit == courses.get(i).getCredit()){
                coursesNew.add(courses.get(i));
            }
        }
        return coursesNew;
    }
    public R<List<Course>> findByRCredit(float credit){
        List<Course> courses = courseRepository.findAll();
        List<Course> coursesNew = new ArrayList<>();
        for (int i = 0;i < courses.size();i++){
            if (credit == courses.get(i).getCredit()){
                coursesNew.add(courses.get(i));
            }
        }
        R<List<Course>> RAll = new R<>();
        RAll.setData(coursesNew);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }
    public R<List<Course>> findByRCreditLike(float credit){
        int flag = 0;
        int creditInt = (int)credit;
        if ((int)credit == credit){
            flag = 1;
        }
        List<Course> course = courseRepository.findAll();
        List<Course> coursesNew = new ArrayList<>();
        for (int i = 0;i < course.size();i++){
            if (String.valueOf(course.get(i).getCredit()).indexOf(String.valueOf(credit)) >= 0 && flag == 0){
                coursesNew.add(course.get(i));
            }
            if (String.valueOf(course.get(i).getCredit()).indexOf(String.valueOf(creditInt)) >= 0 && flag == 1){
                coursesNew.add(course.get(i));
            }
        }
        R<List<Course>> RAll = new R<>();
        RAll.setData(coursesNew);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }
}
