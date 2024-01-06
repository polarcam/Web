package cn.edu.ctbu.grademanagement.service.StudentService;

import cn.edu.ctbu.grademanagement.domain.Student;
import cn.edu.ctbu.grademanagement.exception.REnum;
import cn.edu.ctbu.grademanagement.vo.R;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface StudentService {

    List<Student> findAll();
    R<List<Student>> findRAll();
    public R<List<Student>> findByRName(String name);
    public R<List<Student>> findByRNameLike(String name);
    List<Student> findByName(String name);
    public R<Student> findByRSno(String sno);
    public R<List<Student>> findByRSnoLike(String sno);
    Student findBySno(String Sno);
    public R<List<Student>> findByRAge(Integer age);
    public R<List<Student>> findByRAgeLike(Integer age);
    List<Student> findByAge(Integer age);
    public R<List<Student>> findByRSex(String sex);
    public R<List<Student>> findByRSexLike(String sex);
    List<Student> findBySex(String sex);
    public R<List<Student>> findByRDept(String dept);
    public R<List<Student>> findByRDeptLike(String dept);
    List<Student> findByDept(String dept);
    public R<Student> findByRNameAndPassword(String username,String password);
    public R<Student> findByRSnoAndPassword(String Sno,String password);
    Student insert(Student student);
    Student update(Student student);
    void deleteId(Integer id);
    Student findByNameAndPassword(String username,String password);
    Student findBySnoAndPassword(String Sno,String password);

}
