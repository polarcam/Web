package cn.edu.ctbu.grademanagement.service.CourseService;

import cn.edu.ctbu.grademanagement.domain.Course;
import cn.edu.ctbu.grademanagement.vo.R;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    public List<Course> findByName(String name);
    public R<List<Course>> findByRName(String name);
    public R<List<Course>> findByRNameLike(String name);
    public Course findByCno(String Cno);
    public R<Course> findByRCno(String Cno);
    public R<List<Course>> findByRCnoLike(String Cno);
    public List<Course> findByHour(Integer hour);
    public R<List<Course>> findByRHour(Integer hour);
    public R<List<Course>> findByRHourLike(Integer hour);
    public List<Course> findByCredit(float credit);
    public R<List<Course>> findByRCredit(float credit);
    public R<List<Course>> findByRCreditLike(float credit);
    public Course insert(Course course);
    public List<Course> findAll();
    public R<List<Course>> findRAll();
    public Course update(Course course);
    public void deleteId(Integer id);
}
