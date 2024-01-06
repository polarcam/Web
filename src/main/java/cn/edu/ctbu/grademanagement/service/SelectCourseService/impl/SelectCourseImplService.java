package cn.edu.ctbu.grademanagement.service.SelectCourseService.impl;

import cn.edu.ctbu.grademanagement.domain.SelectCourse;
import cn.edu.ctbu.grademanagement.exception.REnum;
import cn.edu.ctbu.grademanagement.repository.SelectCourseRepository;
import cn.edu.ctbu.grademanagement.service.SelectCourseService.SelectCourseService;
import cn.edu.ctbu.grademanagement.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class SelectCourseImplService implements SelectCourseService {
    @Autowired
    private SelectCourseRepository selectCourseRepository;

    /**
     * 查询所有选课信息
     * @return
     */
    public List<SelectCourse> findAll(){
        return selectCourseRepository.findAll();
    }
    public R<List<SelectCourse>> findRAll(){
        R<List<SelectCourse>> selectCoursesR = new R<>();
        selectCoursesR.setCode(REnum.SUCCESS.getCode());
        selectCoursesR.setMsg(REnum.SUCCESS.getMsg());
        selectCoursesR.setData(selectCourseRepository.findAll());
        return selectCoursesR;
    }
    public List<SelectCourse> findByCnoAndSno(String cno,String sno){
        List<SelectCourse> selectCourses = selectCourseRepository.findAll();
        List<SelectCourse> selectCoursesNew = new ArrayList<>();
        for (int i = 0;i < selectCourses.size();i++){
            if (selectCourses.get(i).getCno().equals(cno) && selectCourses.get(i).getSno().equals(sno)){
                selectCoursesNew.add(selectCourses.get(i));
            }
        }
        return selectCoursesNew;
    }
    public R<List<SelectCourse>> findByRCnoAndSno(String cno,String sno) {
        List<SelectCourse> selectCourses = selectCourseRepository.findAll();
        List<SelectCourse> selectCoursesNew = new ArrayList<>();
        for (int i = 0;i < selectCourses.size();i++){
            if (selectCourses.get(i).getCno().equals(cno) && selectCourses.get(i).getSno().equals(sno)){
                selectCoursesNew.add(selectCourses.get(i));
            }
        }
        R<List<SelectCourse>> selectCoursesR = new R<>();
        selectCoursesR.setCode(REnum.SUCCESS.getCode());
        selectCoursesR.setMsg(REnum.SUCCESS.getMsg());
        selectCoursesR.setData(selectCoursesNew);
        return selectCoursesR;
    }

    /**
     * 通过课号查询选课信息
     * @param cno
     * @return
     */
    public List<SelectCourse> findByCno(String cno){
        List<SelectCourse> selectCourses = selectCourseRepository.findAll();
        List<SelectCourse> selectCoursesNew = new ArrayList<>();
        for (int i = 0;i < selectCourses.size();i++){
            if (cno.equals(selectCourses.get(i).getCno())){
                selectCoursesNew.add(selectCourses.get(i));
            }
        }
        return selectCoursesNew;
    }
    public R<List<SelectCourse>> findByRCno(String cno){
        List<SelectCourse> selectCourses = selectCourseRepository.findAll();
        List<SelectCourse> selectCoursesNew = new ArrayList<>();
        for (int i = 0;i < selectCourses.size();i++){
            if (cno.equals(selectCourses.get(i).getCno())){
                selectCoursesNew.add(selectCourses.get(i));
            }
        }
        R<List<SelectCourse>> selectCoursesR = new R<>();
        selectCoursesR.setCode(REnum.SUCCESS.getCode());
        selectCoursesR.setMsg(REnum.SUCCESS.getMsg());
        selectCoursesR.setData(selectCoursesNew);
        return selectCoursesR;
    }

    /**
     * 通过学号查询选课信息
     * @param sno
     * @return
     */
    public List<SelectCourse> findBySno(String sno){
        List<SelectCourse> selectCourses = selectCourseRepository.findAll();
        List<SelectCourse> selectCoursesNew = new ArrayList<>();
        for (int i = 0;i < selectCourses.size();i++){
            if (sno.equals(selectCourses.get(i).getSno())){
                selectCoursesNew.add(selectCourses.get(i));
            }
        }
        return selectCoursesNew;
    }
    public R<List<SelectCourse>> findByRSno(String sno){
        List<SelectCourse> selectCourses = selectCourseRepository.findAll();
        List<SelectCourse> selectCoursesNew = new ArrayList<>();
        for (int i = 0;i < selectCourses.size();i++){
            if (sno.equals(selectCourses.get(i).getSno())){
                selectCoursesNew.add(selectCourses.get(i));
            }
        }
        R<List<SelectCourse>> selectCoursesR = new R<>();
        selectCoursesR.setCode(REnum.SUCCESS.getCode());
        selectCoursesR.setMsg(REnum.SUCCESS.getMsg());
        selectCoursesR.setData(selectCoursesNew);
        return selectCoursesR;
    }

    public List<SelectCourse> findByScore(Integer score){
        List<SelectCourse> selectCourses = selectCourseRepository.findAll();
        List<SelectCourse> selectCoursesNew = new ArrayList<>();
        for (int i = 0;i < selectCourses.size();i++){
            if (score.equals(selectCourses.get(i).getScore())){
                selectCoursesNew.add(selectCourses.get(i));
            }
        }
        return selectCoursesNew;
    }
    public R<List<SelectCourse>> findByRScore(Integer score){
        List<SelectCourse> selectCourses = selectCourseRepository.findAll();
        List<SelectCourse> selectCoursesNew = new ArrayList<>();
        for (int i = 0;i < selectCourses.size();i++){
            if (score.equals(selectCourses.get(i).getScore())){
                selectCoursesNew.add(selectCourses.get(i));
            }
        }
        R<List<SelectCourse>> selectCoursesR = new R<>();
        selectCoursesR.setCode(REnum.SUCCESS.getCode());
        selectCoursesR.setMsg(REnum.SUCCESS.getMsg());
        selectCoursesR.setData(selectCoursesNew);
        return selectCoursesR;
    }

    public SelectCourse insert(SelectCourse selectCourse){
        selectCourseRepository.save(selectCourse);
        return selectCourse;
    }

    public void insert(String cno,String sno){
        SelectCourse selectCourse = new SelectCourse();
        selectCourse.setCno(cno);
        selectCourse.setSno(sno);
        selectCourseRepository.save(selectCourse);
    }

    public SelectCourse update(SelectCourse selectCourse){
        selectCourseRepository.save(selectCourse);
        return selectCourse;
    }

    public void deleteId(Integer id){
        selectCourseRepository.deleteById(id);
    }

}
