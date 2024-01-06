package cn.edu.ctbu.grademanagement.repository;

import cn.edu.ctbu.grademanagement.domain.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator,Integer> {
}
