package cn.edu.ctbu.grademanagement.service.StudentCourseMessageService.impl;

import cn.edu.ctbu.grademanagement.service.StudentCourseMessageService.StudentCourseMessageService;
import cn.edu.ctbu.grademanagement.vo.StudentCourseMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生课程信息
 */
@Service
public class StudentCourseMessageImplService implements StudentCourseMessageService {

    /**
     * 课号模糊查找
     * @param cno
     * @param SCMList
     * @return
     */
    public List<StudentCourseMessage> findByCnoLike(String cno,List<StudentCourseMessage> SCMList){
        List<StudentCourseMessage> studentCourseMessages = new ArrayList<>();
        for (int i = 0;i < SCMList.size();i++){
            if (SCMList.get(i).getCno().indexOf(cno) >= 0){
                studentCourseMessages.add(SCMList.get(i));
            }
        }
        return studentCourseMessages;
    }

    /**
     * 课名模糊查找
     * @param cname
     * @param SCMList
     * @return
     */
    public List<StudentCourseMessage> findByCnameLike(String cname,List<StudentCourseMessage> SCMList){
        List<StudentCourseMessage> studentCourseMessages = new ArrayList<>();
        for (int i = 0;i < SCMList.size();i++){
            if (SCMList.get(i).getCname().indexOf(cname) >= 0){
                studentCourseMessages.add(SCMList.get(i));
            }
        }
        return studentCourseMessages;
    }

    /**
     * 学时模糊查询
     * @param hour
     * @param SCMList
     * @return
     */
    public List<StudentCourseMessage> findByHourLike(int hour,List<StudentCourseMessage> SCMList){
        List<StudentCourseMessage> studentCourseMessages = new ArrayList<>();
        for (int i = 0;i < SCMList.size();i++){
            if (String.valueOf(SCMList.get(i).getHour()).indexOf(String.valueOf(hour)) >= 0){
                studentCourseMessages.add(SCMList.get(i));
            }
        }
        return studentCourseMessages;
    }

    /**
     * 分数模糊查询
     * @param score
     * @param SCMList
     * @return
     */
    public List<StudentCourseMessage> findByScoreLike(int score,List<StudentCourseMessage> SCMList){
        List<StudentCourseMessage> studentCourseMessages = new ArrayList<>();
        for (int i = 0;i < SCMList.size();i++){
            if (String.valueOf(SCMList.get(i).getScore()).indexOf(String.valueOf(score)) >= 0){
                studentCourseMessages.add(SCMList.get(i));
            }
        }
        return studentCourseMessages;
    }



    /**
     * 学分模糊查询
     * @param credit
     * @param SCMList
     * @return
     */
    public List<StudentCourseMessage> findByCreditLike(float credit,List<StudentCourseMessage> SCMList){
        int flag = 0;
        int creditInt = (int)credit;
        if ((int)credit == credit){
            flag = 1;
        }
        List<StudentCourseMessage> studentCourseMessages = new ArrayList<>();
        for (int i = 0;i < SCMList.size();i++){
            if (String.valueOf(SCMList.get(i).getCredit()).indexOf(String.valueOf(credit)) >= 0 && flag == 0){
                studentCourseMessages.add(SCMList.get(i));
            }
            if (String.valueOf(SCMList.get(i).getCredit()).indexOf(String.valueOf(creditInt)) >= 0 && flag == 1){
                studentCourseMessages.add(SCMList.get(i));
            }
        }
        return studentCourseMessages;
    }



    /**
     * 课号精确查找
     * @param cno
     * @param SCMList
     * @return
     */
    public List<StudentCourseMessage> findByCno(String cno,List<StudentCourseMessage> SCMList){
        List<StudentCourseMessage> studentCourseMessages = new ArrayList<>();
        for (int i = 0;i < SCMList.size();i++){
            if (SCMList.get(i).getCno().equals(cno)){
                studentCourseMessages.add(SCMList.get(i));
            }
        }
        return studentCourseMessages;
    }

    /**
     * 课名精确查找
     * @param cname
     * @param SCMList
     * @return
     */
    public List<StudentCourseMessage> findByCname(String cname,List<StudentCourseMessage> SCMList){
        List<StudentCourseMessage> studentCourseMessages = new ArrayList<>();
        for (int i = 0;i < SCMList.size();i++){
            if (SCMList.get(i).getCname().equals(cname)){
                studentCourseMessages.add(SCMList.get(i));
            }
        }
        return studentCourseMessages;
    }

    /**
     * 学时精确查询
     * @param hour
     * @param SCMList
     * @return
     */
    public List<StudentCourseMessage> findByHour(int hour,List<StudentCourseMessage> SCMList){
        List<StudentCourseMessage> studentCourseMessages = new ArrayList<>();
        for (int i = 0;i < SCMList.size();i++){
            if (hour == SCMList.get(i).getHour()){
                studentCourseMessages.add(SCMList.get(i));
            }
        }
        return studentCourseMessages;
    }

    /**
     * 分数精确查询
     * @param score
     * @param SCMList
     * @return
     */
    public List<StudentCourseMessage> findByScore(int score,List<StudentCourseMessage> SCMList){
        List<StudentCourseMessage> studentCourseMessages = new ArrayList<>();
        for (int i = 0;i < SCMList.size();i++){
            if (score == SCMList.get(i).getScore()){
                studentCourseMessages.add(SCMList.get(i));
            }
        }
        return studentCourseMessages;
    }


    /**
     * 学分精确查询
     * @param credit
     * @param SCMList
     * @return
     */
    public List<StudentCourseMessage> findByCredit(float credit,List<StudentCourseMessage> SCMList){
        List<StudentCourseMessage> studentCourseMessages = new ArrayList<>();
        for (int i = 0;i < SCMList.size();i++){
            if (credit == SCMList.get(i).getCredit()){
                studentCourseMessages.add(SCMList.get(i));
            }
        }
        return studentCourseMessages;
    }
}
