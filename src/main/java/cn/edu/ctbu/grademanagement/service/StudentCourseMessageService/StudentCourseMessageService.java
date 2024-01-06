package cn.edu.ctbu.grademanagement.service.StudentCourseMessageService;

import cn.edu.ctbu.grademanagement.vo.StudentCourseMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentCourseMessageService {
    public List<StudentCourseMessage> findByCnoLike(String cno, List<StudentCourseMessage> SCMList);
    public List<StudentCourseMessage> findByCnameLike(String cname,List<StudentCourseMessage> SCMList);
    public List<StudentCourseMessage> findByHourLike(int hour,List<StudentCourseMessage> SCMList);
    public List<StudentCourseMessage> findByScoreLike(int score,List<StudentCourseMessage> SCMList);
    public List<StudentCourseMessage> findByCreditLike(float credit,List<StudentCourseMessage> SCMList);
    public List<StudentCourseMessage> findByCno(String cno,List<StudentCourseMessage> SCMList);
    public List<StudentCourseMessage> findByCname(String cname,List<StudentCourseMessage> SCMList);
    public List<StudentCourseMessage> findByHour(int hour,List<StudentCourseMessage> SCMList);
    public List<StudentCourseMessage> findByScore(int score,List<StudentCourseMessage> SCMList);
    public List<StudentCourseMessage> findByCredit(float credit,List<StudentCourseMessage> SCMList);

}
