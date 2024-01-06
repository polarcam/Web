package cn.edu.ctbu.grademanagement.aspect;



import cn.edu.ctbu.grademanagement.core.RUtil;
import cn.edu.ctbu.grademanagement.exception.REnum;
import cn.edu.ctbu.grademanagement.exception.RException;
import cn.edu.ctbu.grademanagement.vo.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 */

@RestControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    public R handel(Exception e){
        if (e instanceof RException){
            RException rException =(RException) e;
            return RUtil.error(rException.getCode(),rException.getMessage());
        }
        return RUtil.error(REnum.UNKOWN_ERR);
    }
}
