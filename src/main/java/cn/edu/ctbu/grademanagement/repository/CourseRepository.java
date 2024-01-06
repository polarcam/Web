package cn.edu.ctbu.grademanagement.repository;

import cn.edu.ctbu.grademanagement.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
