package cn.edu.ctbu.grademanagement.service.AdministratorService;


import cn.edu.ctbu.grademanagement.domain.Administrator;
import cn.edu.ctbu.grademanagement.vo.R;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdministratorService {
    List<Administrator> findAll();
    R<List<Administrator>> findRAll();
    List<Administrator> findByName(String name);
    R<List<Administrator>> findByRName(String name);
    Administrator findByAno(String Ano);
    R<Administrator> findByRAno(String Ano);
    List<Administrator> findByAge(Integer age);
    R<List<Administrator>> findByRAge(Integer age);
    List<Administrator> findBySex(String sex);
    R<List<Administrator>> findByRSex(String sex);
    Administrator findByNameAndPassword(String name,String password);
    R<Administrator> findByRNameAndPassword(String name,String password);
    Administrator findByAnoAndPassword(String Ano,String password);
    R<Administrator> findByRAnoAndPassword(String Ano, String password);
    Administrator insert(Administrator administrator);
    Administrator update(Administrator administrator);
    void deleteId(Integer id);
    
}
