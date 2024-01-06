package cn.edu.ctbu.grademanagement.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "tb_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 学生姓名
     */
    private String sname;
    /**
     * 学生学号
     */
    private String sno;
    /**
     * 学生年龄
     */
    private Integer age;
    /**
     * 学生性别
     */
    private String sex;
    /**
     * 学生密码
     */
    private String password;
    /**
     * 学生所在学院
     */
    private String dept;
}
