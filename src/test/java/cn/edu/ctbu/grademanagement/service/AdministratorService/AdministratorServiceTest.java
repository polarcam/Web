package cn.edu.ctbu.grademanagement.service.AdministratorService;

import cn.edu.ctbu.grademanagement.domain.Administrator;
import cn.edu.ctbu.grademanagement.repository.AdministratorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdministratorServiceTest {
    @Autowired
    private AdministratorRepository administratorRepository;

    @Test
    void insert() {
        Administrator administrator = new Administrator();
        administrator.setAge(1);
        administrator.setAno("2020413318");
        administrator.setAname("赵六");
        administrator.setSex("男");
        administrator.setSal(3000);
        administrator.setPassword("abcdef");
        administratorRepository.save(administrator);
    }

    @Test
    void deleteId() {
        Integer id = 2;
        administratorRepository.deleteById(id);
    }
}