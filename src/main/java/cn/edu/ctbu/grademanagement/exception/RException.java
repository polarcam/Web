package cn.edu.ctbu.grademanagement.exception;

import lombok.Data;

/**
 * 自定义的运行时异常类
 */

@Data
public class RException extends RuntimeException{
    private Integer code;
    public RException(Integer code,String msg){
        super(msg);
        this.code = code;
    }

    public RException(REnum rEnum){
        super(rEnum.getMsg());
        this.code = rEnum.getCode();
    }
}
