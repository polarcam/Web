package cn.edu.ctbu.grademanagement.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "tb_administrator")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 管理员工号
     */
    private String ano;
    /**
     * 管理员姓名
     */
    private String aname;
    /**
     * 管理员性别
     */
    private String sex;
    /**
     * 管理员年龄
     */
    private Integer age;
    /**
     * 管理员工资
     */
    private Integer sal;
    /**
     * 管理员密码
     */
    private String password;
}
