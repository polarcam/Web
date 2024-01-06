package cn.edu.ctbu.grademanagement.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "tb_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
