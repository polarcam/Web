package cn.edu.ctbu.grademanagement.core;

import cn.edu.ctbu.grademanagement.exception.REnum;
import cn.edu.ctbu.grademanagement.vo.R;

public class RUtil {
    public static R success(Object object){
        R result = new R();
        result.setCode(1);
        result.setData(object);
        result.setMsg("执行成功");

        return result;
    }
    public static R success(){
        return success(null);
    }

    public static R error(Integer code,String msg){
        R result = new R();
        result.setCode(code);
        result.setData(null);
        result.setMsg(msg);

        return result;
    }

    public static R error(REnum rEnum){
        return error(rEnum.getCode(),rEnum.getMsg());
    }

}
