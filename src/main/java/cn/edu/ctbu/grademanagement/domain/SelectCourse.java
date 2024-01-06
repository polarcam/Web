package cn.edu.ctbu.grademanagement.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "tb_selectcourse")
public class SelectCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 学号
     */
    private String sno;
    /**
     * 课号
     */
    private String cno;
    /**
     * 得分
     */
    private float score;

}
