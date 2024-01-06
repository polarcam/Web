package cn.edu.ctbu.grademanagement.service.AdministratorSelectCourseService;

import cn.edu.ctbu.grademanagement.exception.REnum;
import cn.edu.ctbu.grademanagement.vo.AdministratorSelectCourse;
import cn.edu.ctbu.grademanagement.vo.R;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface AdministratorSelectCourseService {

    public R<List<AdministratorSelectCourse>> findByRCnoLike(String cno, List<AdministratorSelectCourse> ASCList);
    public R<List<AdministratorSelectCourse>> findByRCno(String cno,List<AdministratorSelectCourse> ASCList);
    public R<List<AdministratorSelectCourse>> findByRSnoLike(String sno,List<AdministratorSelectCourse> ASCList);
    public R<List<AdministratorSelectCourse>> findByRSno(String sno,List<AdministratorSelectCourse> ASCList);
    public R<List<AdministratorSelectCourse>> findByRSnameLike(String sname,List<AdministratorSelectCourse> ASCList);
    public R<List<AdministratorSelectCourse>> findByRSname(String sname,List<AdministratorSelectCourse> ASCList);
    public R<List<AdministratorSelectCourse>> findByRCnameLike(String cname,List<AdministratorSelectCourse> ASCList);
    public R<List<AdministratorSelectCourse>> findByRCname(String cname,List<AdministratorSelectCourse> ASCList);
    public R<List<AdministratorSelectCourse>> findByRSexLike(String sex,List<AdministratorSelectCourse> ASCList);
    public R<List<AdministratorSelectCourse>> findByRSex(String sex,List<AdministratorSelectCourse> ASCList);
    public R<List<AdministratorSelectCourse>> findByRDeptLike(String dept,List<AdministratorSelectCourse> ASCList);
    public R<List<AdministratorSelectCourse>> findByRDept(String dept,List<AdministratorSelectCourse> ASCList);

}
