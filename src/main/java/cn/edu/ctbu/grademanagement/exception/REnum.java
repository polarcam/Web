package cn.edu.ctbu.grademanagement.exception;

public enum REnum {
    UNKOWN_ERR(-999,"未知错误"),
    COMMON_ERR(-10,"一般错误"),
    LOGIN_ERR(-2,"错误：不正确的用户名或密码"),
    SEARCH_ERR(-11,"错误：数据库中没有必要数据，无法完成完整性约束"),
    DATA_ERR(-12,"错误：数据库中已存在相同数据，不可覆盖原有信息"),
    DELETE_ERR(-13,"错误：删除出错"),
    INSERTCOURSE_ERR(-15,"错误：已有此门课程，课号重复"),
    INSERTSTUDENT_ERR(-17,"错误：已有此学生，学号重复"),
    SUCCESS(1,"成功执行");

    private Integer code;
    private String msg;

    REnum(Integer code ,String msg){
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }
}
