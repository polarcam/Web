package cn.edu.ctbu.grademanagement.service.StudentService.impl;

import cn.edu.ctbu.grademanagement.exception.REnum;
import cn.edu.ctbu.grademanagement.repository.StudentRepository;
import cn.edu.ctbu.grademanagement.service.StudentService.StudentService;
import cn.edu.ctbu.grademanagement.domain.Student;
import cn.edu.ctbu.grademanagement.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentImplService implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    /**
     * 查询所有学生
     * @return 返回List
     */
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    public R<List<Student>> findRAll(){
        List<Student> students = studentRepository.findAll();
        R<List<Student>> RAll = new R<>();
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setData(students);
        return RAll;
    }

    /**
     * 以姓名查询学生
     * @param name
     * @return 返回List
     */
    public List<Student> findByName(String name){
        List<Student> students = studentRepository.findAll();
        List<Student> studentsNew = new ArrayList<>();
        for (int i = 0;i < students.size();i++){
            if (name.equals(students.get(i).getSname())){
                studentsNew.add(students.get(i));
            }
        }
        return studentsNew;
    }
    public R<List<Student>> findByRName(String name){
        List<Student> students = studentRepository.findAll();
        List<Student> studentsNew = new ArrayList<>();
        for (int i = 0;i < students.size();i++){
            if (name.equals(students.get(i).getSname())){
                studentsNew.add(students.get(i));
            }
        }
        R<List<Student>> RAll = new R<>();
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setData(studentsNew);
        return RAll;
    }
    public R<List<Student>> findByRNameLike(String name){
        List<Student> students = studentRepository.findAll();
        List<Student> studentsNew = new ArrayList<>();
        for (int i = 0;i < students.size();i++){
            if (students.get(i).getSname().indexOf(name) >= 0){
                studentsNew.add(students.get(i));
            }
        }
        R<List<Student>> RAll = new R<>();
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setData(studentsNew);
        return RAll;
    }

    /**
     * 以学号查询学生
     * @param Sno
     * @return 返回Student
     */
    public Student findBySno(String Sno){
        List<Student> students = studentRepository.findAll();
        Student student = new Student();
        for (int i = 0;i < students.size();i++){
            if (Sno.equals(students.get(i).getSno())){
                student = students.get(i);
                break;
            }
        }
        return student;
    }
    public R<Student> findByRSno(String sno){
        List<Student> students = studentRepository.findAll();
        Student student = new Student();
        for (int i = 0;i < students.size();i++){
            if (sno.equals(students.get(i).getSno())){
                student = students.get(i);
                break;
            }
        }
        R<Student> RAll = new R<>();
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setData(student);
        return RAll;
    }

    public R<List<Student>> findByRSnoLike(String sno){
        List<Student> students = studentRepository.findAll();
        List<Student> studentsNew = new ArrayList<>();
        for (int i = 0;i < students.size();i++){
            if (students.get(i).getSno().indexOf(sno) >= 0){
                studentsNew.add(students.get(i));
            }
        }
        R<List<Student>> RAll = new R<>();
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setData(studentsNew);
        return RAll;
    }

    /**
     * 以年龄查询学生
     * @param age
     * @return 返回List
     */
    public List<Student> findByAge(Integer age){
        List<Student> students = studentRepository.findAll();
        List<Student> studentsNew = new ArrayList<>();
        for (int i = 0;i < students.size();i++){
            if (age == students.get(i).getAge()){
                studentsNew.add(students.get(i));
            }
        }
        return studentsNew;
    }
    public R<List<Student>> findByRAge(Integer age){
        List<Student> students = studentRepository.findAll();
        List<Student> studentsNew = new ArrayList<>();
        for (int i = 0;i < students.size();i++){
            if (age == students.get(i).getAge()){
                studentsNew.add(students.get(i));
            }
        }
        R<List<Student>> RAll = new R<>();
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setData(studentsNew);
        return RAll;
    }
    public R<List<Student>> findByRAgeLike(Integer age){
        List<Student> students = studentRepository.findAll();
        List<Student> studentsNew = new ArrayList<>();
        for (int i = 0;i < students.size();i++){
            if (String.valueOf(students.get(i).getAge()).indexOf(String.valueOf(age)) >= 0){
                studentsNew.add(students.get(i));
            }
        }
        R<List<Student>> RAll = new R<>();
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setData(studentsNew);
        return RAll;
    }

    /**
     * 以性别查询学生
     * @param sex
     * @return 返回List
     */
    public List<Student> findBySex(String sex){
        List<Student> students = studentRepository.findAll();
        List<Student> studentsNew = new ArrayList<>();
        for (int i = 0;i < students.size();i++){
            if (sex.equals(students.get(i).getSex())){
                studentsNew.add(students.get(i));
            }
        }
        return studentsNew;
    }
    public R<List<Student>> findByRSex(String sex){
        List<Student> students = studentRepository.findAll();
        List<Student> studentsNew = new ArrayList<>();
        for (int i = 0;i < students.size();i++){
            if (sex.equals(students.get(i).getSex())){
                studentsNew.add(students.get(i));
            }
        }
        R<List<Student>> RAll = new R<>();
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setData(studentsNew);
        return RAll;
    }
    public R<List<Student>> findByRSexLike(String sex){
        List<Student> students = studentRepository.findAll();
        List<Student> studentsNew = new ArrayList<>();
        for (int i = 0;i < students.size();i++){
            if (students.get(i).getSex().indexOf(sex) >= 0){
                studentsNew.add(students.get(i));
            }
        }
        R<List<Student>> RAll = new R<>();
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setData(studentsNew);
        return RAll;
    }

    /**
     * 以院系查询学生信息
     * @param dept
     * @return
     */
    public List<Student> findByDept(String dept){
        List<Student> students = studentRepository.findAll();
        List<Student> studentsNew = new ArrayList<>();
        for (int i = 0;i < students.size();i++){
            if (dept.equals(students.get(i).getDept())){
                studentsNew.add(students.get(i));
            }
        }
        return studentsNew;
    }
    public R<List<Student>> findByRDept(String dept){
        List<Student> students = studentRepository.findAll();
        List<Student> studentsNew = new ArrayList<>();
        for (int i = 0;i < students.size();i++){
            if (dept.equals(students.get(i).getDept())){
                studentsNew.add(students.get(i));
            }
        }
        R<List<Student>> RAll = new R<>();
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setData(studentsNew);
        return RAll;
    }
    public R<List<Student>> findByRDeptLike(String dept){
        List<Student> students = studentRepository.findAll();
        List<Student> studentsNew = new ArrayList<>();
        for (int i = 0;i < students.size();i++){
            if (students.get(i).getDept().indexOf(dept) >= 0){
                studentsNew.add(students.get(i));
            }
        }
        R<List<Student>> RAll = new R<>();
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setData(studentsNew);
        return RAll;
    }

    /**
     * 检查密码和用户名（姓名）
     * @param username
     * @param password
     * @return
     */
    public Student findByNameAndPassword(String username,String password){
        List<Student> students = studentRepository.findAll();
        Student student = new Student();
        for (int i = 0;i < students.size();i++){
            if (username.equals(students.get(i).getSname()) && password.equals(students.get(i).getPassword())){
                student = students.get(i);
                break;
            }
        }
        return student;
    }
    public R<Student> findByRNameAndPassword(String username,String password){
        List<Student> students = studentRepository.findAll();
        Student student = new Student();
        for (int i = 0;i < students.size();i++){
            if (username.equals(students.get(i).getSname()) && password.equals(students.get(i).getPassword())){
                student = students.get(i);
                break;
            }
        }
        R<Student> RAll = new R<>();
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setData(student);
        return RAll;
    }

    /**
     * 检查密码和用户名（学号）
     * @param Sno
     * @param password
     * @return
     */
    public Student findBySnoAndPassword(String Sno,String password){
        List<Student> students = studentRepository.findAll();
        Student student = new Student();
        for (int i = 0;i < students.size();i++){
            if (Sno.equals(students.get(i).getSno()) && password.equals(students.get(i).getPassword())){
                student = students.get(i);
                break;
            }
        }
        return student;
    }
    public R<Student> findByRSnoAndPassword(String Sno,String password){
        List<Student> students = studentRepository.findAll();
        Student student = new Student();
        for (int i = 0;i < students.size();i++){
            if (Sno.equals(students.get(i).getSno()) && password.equals(students.get(i).getPassword())){
                student = students.get(i);
                break;
            }
        }
        R<Student> RAll = new R<>();
        RAll.setMsg(REnum.SUCCESS.getMsg());
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setData(student);
        return RAll;
    }

    /**
     * 学生信息的增加
     * @param student
     * @return 返回Student
     */
    public Student insert(Student student){
        studentRepository.save(student);
        return student;
    }

    /**
     * 学生信息的更新
     * @param student
     * @return
     */
    public Student update(Student student){
        studentRepository.save(student);
        return student;
    }

    /**
     * 学生信息通过id删除
     * @param id
     */
    public void deleteId(Integer id){
        studentRepository.deleteById(id);
    }

}
