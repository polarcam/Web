package cn.edu.ctbu.grademanagement.vo;

import lombok.Data;

@Data
public class StudentSelectCourse {
    private Integer id;

    /**
     * 课号
     */
    private String cno;
    /**
     * 课名
     */
    private String cname;
    /**
     * 课时
     */
    private Integer hour;
    /**
     * 学分
     */
    private float credit;
    /**
     * 学生是否已选本门课
     */
    private Integer yesOrNo;
}
