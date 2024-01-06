package cn.edu.ctbu.grademanagement.service.StudentSelectCourseService;

import cn.edu.ctbu.grademanagement.vo.StudentSelectCourse;
import cn.edu.ctbu.grademanagement.vo.StudentSelectCourse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentSelectCourseService {
    public List<StudentSelectCourse> findByCnoLike(String cno, List<StudentSelectCourse> SSCList);
    public List<StudentSelectCourse> findByCnameLike(String cname,List<StudentSelectCourse> SSCList);
    public List<StudentSelectCourse> findByHourLike(int hour,List<StudentSelectCourse> SSCList);
    public List<StudentSelectCourse> findByCreditLike(float credit,List<StudentSelectCourse> SSCList);
    public List<StudentSelectCourse> findByCno(String cno,List<StudentSelectCourse> SSCList);
    public List<StudentSelectCourse> findByCname(String cname,List<StudentSelectCourse> SSCList);
    public List<StudentSelectCourse> findByHour(int hour,List<StudentSelectCourse> SSCList);
    public List<StudentSelectCourse> findByCredit(float credit,List<StudentSelectCourse> SSCList);
    public List<StudentSelectCourse> findByYesOrNo(Integer yesOrNo,List<StudentSelectCourse> SSCList);
    public List<StudentSelectCourse> findByYesOrNoLike(Integer yesOrNo,List<StudentSelectCourse> SSCList);
}
