package cn.edu.ctbu.grademanagement.service.AdministratorSelectCourseService.impl;

import cn.edu.ctbu.grademanagement.exception.REnum;
import cn.edu.ctbu.grademanagement.service.AdministratorSelectCourseService.AdministratorSelectCourseService;
import cn.edu.ctbu.grademanagement.vo.AdministratorSelectCourse;
import cn.edu.ctbu.grademanagement.vo.R;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdministratorSelectCourseImplService implements AdministratorSelectCourseService {
//    private String sno;
//    private String sname;
//    private String sex;
//    private String dept;
//    private String cno;
//    private String cname;

    public R<List<AdministratorSelectCourse>> findByRCnoLike(String cno, List<AdministratorSelectCourse> ASCList) {
        List<AdministratorSelectCourse> administratorSelectCourses = new ArrayList<>();
        for (int i = 0; i < ASCList.size(); i++) {
            if (ASCList.get(i).getCno().indexOf(cno) >= 0) {
                administratorSelectCourses.add(ASCList.get(i));
            }
        }
        R<List<AdministratorSelectCourse>> RAll = new R<>();
        RAll.setData(administratorSelectCourses);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }

    public R<List<AdministratorSelectCourse>> findByRCno(String cno, List<AdministratorSelectCourse> ASCList) {
        List<AdministratorSelectCourse> administratorSelectCourses = new ArrayList<>();
        for (int i = 0; i < ASCList.size(); i++) {
            if (cno.equals(ASCList.get(i).getCno())) {
                administratorSelectCourses.add(ASCList.get(i));
            }
        }
        R<List<AdministratorSelectCourse>> RAll = new R<>();
        RAll.setData(administratorSelectCourses);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }

    public R<List<AdministratorSelectCourse>> findByRSnoLike(String sno, List<AdministratorSelectCourse> ASCList) {
        List<AdministratorSelectCourse> administratorSelectCourses = new ArrayList<>();
        for (int i = 0; i < ASCList.size(); i++) {
            if (ASCList.get(i).getSno().indexOf(sno) >= 0) {
                administratorSelectCourses.add(ASCList.get(i));
            }
        }
        R<List<AdministratorSelectCourse>> RAll = new R<>();
        RAll.setData(administratorSelectCourses);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }

    public R<List<AdministratorSelectCourse>> findByRSno(String sno, List<AdministratorSelectCourse> ASCList) {
        List<AdministratorSelectCourse> administratorSelectCourses = new ArrayList<>();
        for (int i = 0; i < ASCList.size(); i++) {
            if (sno.equals(ASCList.get(i).getSno())) {
                administratorSelectCourses.add(ASCList.get(i));
            }
        }
        R<List<AdministratorSelectCourse>> RAll = new R<>();
        RAll.setData(administratorSelectCourses);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }

    public R<List<AdministratorSelectCourse>> findByRSnameLike(String sname, List<AdministratorSelectCourse> ASCList) {
        List<AdministratorSelectCourse> administratorSelectCourses = new ArrayList<>();
        for (int i = 0; i < ASCList.size(); i++) {
            if (ASCList.get(i).getSname().indexOf(sname) >= 0) {
                administratorSelectCourses.add(ASCList.get(i));
            }
        }
        R<List<AdministratorSelectCourse>> RAll = new R<>();
        RAll.setData(administratorSelectCourses);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }

    public R<List<AdministratorSelectCourse>> findByRSname(String sname, List<AdministratorSelectCourse> ASCList) {
        List<AdministratorSelectCourse> administratorSelectCourses = new ArrayList<>();
        for (int i = 0; i < ASCList.size(); i++) {
            if (sname.equals(ASCList.get(i).getSname())) {
                administratorSelectCourses.add(ASCList.get(i));
            }
        }
        R<List<AdministratorSelectCourse>> RAll = new R<>();
        RAll.setData(administratorSelectCourses);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }


    public R<List<AdministratorSelectCourse>> findByRCnameLike(String cname, List<AdministratorSelectCourse> ASCList) {
        List<AdministratorSelectCourse> administratorSelectCourses = new ArrayList<>();
        for (int i = 0; i < ASCList.size(); i++) {
            if (ASCList.get(i).getCname().indexOf(cname) >= 0) {
                administratorSelectCourses.add(ASCList.get(i));
            }
        }
        R<List<AdministratorSelectCourse>> RAll = new R<>();
        RAll.setData(administratorSelectCourses);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }

    public R<List<AdministratorSelectCourse>> findByRCname(String cname, List<AdministratorSelectCourse> ASCList) {
        List<AdministratorSelectCourse> administratorSelectCourses = new ArrayList<>();
        for (int i = 0; i < ASCList.size(); i++) {
            if (cname.equals(ASCList.get(i).getCname())) {
                administratorSelectCourses.add(ASCList.get(i));
            }
        }
        R<List<AdministratorSelectCourse>> RAll = new R<>();
        RAll.setData(administratorSelectCourses);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }

    public R<List<AdministratorSelectCourse>> findByRSexLike(String sex, List<AdministratorSelectCourse> ASCList) {
        List<AdministratorSelectCourse> administratorSelectCourses = new ArrayList<>();
        for (int i = 0; i < ASCList.size(); i++) {
            if (ASCList.get(i).getSex().indexOf(sex) >= 0) {
                administratorSelectCourses.add(ASCList.get(i));
            }
        }
        R<List<AdministratorSelectCourse>> RAll = new R<>();
        RAll.setData(administratorSelectCourses);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }

    public R<List<AdministratorSelectCourse>> findByRSex(String sex, List<AdministratorSelectCourse> ASCList) {
        List<AdministratorSelectCourse> administratorSelectCourses = new ArrayList<>();
        for (int i = 0; i < ASCList.size(); i++) {
            if (sex.equals(ASCList.get(i).getSex())) {
                administratorSelectCourses.add(ASCList.get(i));
            }
        }
        R<List<AdministratorSelectCourse>> RAll = new R<>();
        RAll.setData(administratorSelectCourses);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }

    public R<List<AdministratorSelectCourse>> findByRDeptLike(String dept, List<AdministratorSelectCourse> ASCList) {
        List<AdministratorSelectCourse> administratorSelectCourses = new ArrayList<>();
        for (int i = 0; i < ASCList.size(); i++) {
            if (ASCList.get(i).getDept().indexOf(dept) >= 0) {
                administratorSelectCourses.add(ASCList.get(i));
            }
        }
        R<List<AdministratorSelectCourse>> RAll = new R<>();
        RAll.setData(administratorSelectCourses);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }

    public R<List<AdministratorSelectCourse>> findByRDept(String dept, List<AdministratorSelectCourse> ASCList) {
        List<AdministratorSelectCourse> administratorSelectCourses = new ArrayList<>();
        for (int i = 0; i < ASCList.size(); i++) {
            if (dept.equals(ASCList.get(i).getDept())) {
                administratorSelectCourses.add(ASCList.get(i));
            }
        }
        R<List<AdministratorSelectCourse>> RAll = new R<>();
        RAll.setData(administratorSelectCourses);
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        return RAll;
    }
}


