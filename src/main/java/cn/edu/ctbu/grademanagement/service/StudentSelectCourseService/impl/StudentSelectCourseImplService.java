package cn.edu.ctbu.grademanagement.service.StudentSelectCourseService.impl;

import cn.edu.ctbu.grademanagement.service.StudentSelectCourseService.StudentSelectCourseService;
import cn.edu.ctbu.grademanagement.vo.StudentSelectCourse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentSelectCourseImplService implements StudentSelectCourseService {
    /**
     * 课号模糊查找
     * @param cno
     * @param SSCList
     * @return
     */
    public List<StudentSelectCourse> findByCnoLike(String cno, List<StudentSelectCourse> SSCList){
        List<StudentSelectCourse> studentSelectCourses = new ArrayList<>();
        for (int i = 0;i < SSCList.size();i++){
            if (SSCList.get(i).getCno().indexOf(cno) >= 0){
                studentSelectCourses.add(SSCList.get(i));
            }
        }
        return studentSelectCourses;
    }

    /**
     * 课名模糊查找
     * @param cname
     * @param SSCList
     * @return
     */
    public List<StudentSelectCourse> findByCnameLike(String cname,List<StudentSelectCourse> SSCList){
        List<StudentSelectCourse> studentSelectCourses = new ArrayList<>();
        for (int i = 0;i < SSCList.size();i++){
            if (SSCList.get(i).getCname().indexOf(cname) >= 0){
                studentSelectCourses.add(SSCList.get(i));
            }
        }
        return studentSelectCourses;
    }

    /**
     * 学时模糊查询
     * @param hour
     * @param SSCList
     * @return
     */
    public List<StudentSelectCourse> findByHourLike(int hour,List<StudentSelectCourse> SSCList){
        List<StudentSelectCourse> studentSelectCourses = new ArrayList<>();
        for (int i = 0;i < SSCList.size();i++){
            if (String.valueOf(SSCList.get(i).getHour()).indexOf(String.valueOf(hour)) >= 0){
                studentSelectCourses.add(SSCList.get(i));
            }
        }
        return studentSelectCourses;
    }

    /**
     * 学分模糊查询
     * @param credit
     * @param SSCList
     * @return
     */
    public List<StudentSelectCourse> findByCreditLike(float credit,List<StudentSelectCourse> SSCList){
        int flag = 0;
        int creditInt = (int)credit;
        if ((int)credit == credit){
            flag = 1;
        }
        List<StudentSelectCourse> studentSelectCourses = new ArrayList<>();
        for (int i = 0;i < SSCList.size();i++){
            if (String.valueOf(SSCList.get(i).getCredit()).indexOf(String.valueOf(credit)) >= 0 && flag == 0){
                studentSelectCourses.add(SSCList.get(i));
            }
            if (String.valueOf(SSCList.get(i).getCredit()).indexOf(String.valueOf(creditInt)) >= 0 && flag == 1){
                studentSelectCourses.add(SSCList.get(i));
            }
        }
        return studentSelectCourses;
    }

    /**
     * 学生是否选课模糊查询
     * @return
     */
    public List<StudentSelectCourse> findByYesOrNoLike(Integer yesOrNo,List<StudentSelectCourse> SSCList){
        List<StudentSelectCourse> studentSelectCourses = new ArrayList<>();
        String yesOrNoString = String.valueOf(yesOrNo);
        for (int i = 0;i < SSCList.size();i++){
            if (yesOrNoString.indexOf(String.valueOf(SSCList.get(i).getYesOrNo())) >= 0){
                studentSelectCourses.add(SSCList.get(i));
            }
        }
        return studentSelectCourses;
    }



    /**
     * 课号精确查找
     * @param cno
     * @param SSCList
     * @return
     */
    public List<StudentSelectCourse> findByCno(String cno,List<StudentSelectCourse> SSCList){
        List<StudentSelectCourse> studentSelectCourses = new ArrayList<>();
        for (int i = 0;i < SSCList.size();i++){
            if (SSCList.get(i).getCno().equals(cno)){
                studentSelectCourses.add(SSCList.get(i));
            }
        }
        return studentSelectCourses;
    }

    /**
     * 课名精确查找
     * @param cname
     * @param SSCList
     * @return
     */
    public List<StudentSelectCourse> findByCname(String cname,List<StudentSelectCourse> SSCList){
        List<StudentSelectCourse> studentSelectCourses = new ArrayList<>();
        for (int i = 0;i < SSCList.size();i++){
            if (SSCList.get(i).getCname().equals(cname)){
                studentSelectCourses.add(SSCList.get(i));
            }
        }
        return studentSelectCourses;
    }

    /**
     * 学时精确查询
     * @param hour
     * @param SSCList
     * @return
     */
    public List<StudentSelectCourse> findByHour(int hour,List<StudentSelectCourse> SSCList){
        List<StudentSelectCourse> studentSelectCourses = new ArrayList<>();
        for (int i = 0;i < SSCList.size();i++){
            if (hour == SSCList.get(i).getHour()){
                studentSelectCourses.add(SSCList.get(i));
            }
        }
        return studentSelectCourses;
    }


    /**
     * 学分精确查询
     * @param credit
     * @param SSCList
     * @return
     */
    public List<StudentSelectCourse> findByCredit(float credit,List<StudentSelectCourse> SSCList){
        List<StudentSelectCourse> studentSelectCourses = new ArrayList<>();
        for (int i = 0;i < SSCList.size();i++){
            if (credit == SSCList.get(i).getCredit()){
                studentSelectCourses.add(SSCList.get(i));
            }
        }
        return studentSelectCourses;
    }

    /**
     * 学生是否选课精确查询
     * @return
     */
    public List<StudentSelectCourse> findByYesOrNo(Integer yesOrNo,List<StudentSelectCourse> SSCList){
        List<StudentSelectCourse> studentSelectCourses = new ArrayList<>();
        for (int i = 0;i < SSCList.size();i++){
            if (Objects.equals(yesOrNo, SSCList.get(i).getYesOrNo())){
                studentSelectCourses.add(SSCList.get(i));
            }
        }
        return studentSelectCourses;
    }
}
