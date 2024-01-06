package cn.edu.ctbu.grademanagement.repository;

import cn.edu.ctbu.grademanagement.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
