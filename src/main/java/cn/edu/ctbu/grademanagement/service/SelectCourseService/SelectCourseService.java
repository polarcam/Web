package cn.edu.ctbu.grademanagement.service.SelectCourseService;

import cn.edu.ctbu.grademanagement.domain.SelectCourse;
import cn.edu.ctbu.grademanagement.vo.R;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SelectCourseService {
    List<SelectCourse> findAll();
    List<SelectCourse> findByCno(String cno);
    List<SelectCourse> findBySno(String sno);
    List<SelectCourse> findByScore(Integer score);
    SelectCourse insert(SelectCourse selectCourse);
    SelectCourse update(SelectCourse selectCourse);
    void deleteId(Integer id);
    public List<SelectCourse> findByCnoAndSno(String cno,String sno);
    public void insert(String cno,String sno);
    R<List<SelectCourse>> findRAll();
    public R<List<SelectCourse>> findByRCnoAndSno(String cno,String sno);
    public R<List<SelectCourse>> findByRCno(String cno);
    public R<List<SelectCourse>> findByRSno(String sno);
    public R<List<SelectCourse>> findByRScore(Integer score);
}
