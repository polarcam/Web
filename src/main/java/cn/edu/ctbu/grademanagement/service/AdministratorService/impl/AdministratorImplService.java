package cn.edu.ctbu.grademanagement.service.AdministratorService.impl;

import cn.edu.ctbu.grademanagement.domain.Administrator;
import cn.edu.ctbu.grademanagement.exception.REnum;
import cn.edu.ctbu.grademanagement.repository.AdministratorRepository;

import cn.edu.ctbu.grademanagement.service.AdministratorService.AdministratorService;
import cn.edu.ctbu.grademanagement.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdministratorImplService implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    /**
     * 查询所有管理员
     * @return 返回List
     */
    public List<Administrator> findAll(){
        return administratorRepository.findAll();
    }
    public R<List<Administrator>> findRAll(){
        R<List<Administrator>> RAll = new R<>();
        RAll.setData(administratorRepository.findAll());
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setMsg(REnum.SUCCESS.getMsg());
        return RAll;
    }

    /**
     * 以姓名查询管理员
     * @param name
     * @return 返回List
     */
    public List<Administrator> findByName(String name){
        List<Administrator> administrators = administratorRepository.findAll();
        List<Administrator> administratorsNew = new ArrayList<>();
        for (int i = 0;i < administrators.size();i++){
            if (name.equals(administrators.get(i).getAname())){
                administratorsNew.add(administrators.get(i));
            }
        }
        return administratorsNew;
    }
    public R<List<Administrator>> findByRName(String name){
        R<List<Administrator>> RAll = new R<>();
        List<Administrator> administrators = administratorRepository.findAll();
        List<Administrator> administratorsNew = new ArrayList<>();
        for (int i = 0;i < administrators.size();i++){
            if (name.equals(administrators.get(i).getAname())){
                administratorsNew.add(administrators.get(i));
            }
        }
        RAll.setData(administratorsNew);
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setMsg(REnum.SUCCESS.getMsg());
        return RAll;
    }

    /**
     * 以学号查询管理员
     * @param Ano
     * @return 返回Administrator
     */
    public Administrator findByAno(String Ano){
        List<Administrator> administrators = administratorRepository.findAll();
        Administrator administrator = new Administrator();
        for (int i = 0;i < administrators.size();i++){
            if (Ano.equals(administrators.get(i).getAno())){
                administrator = administrators.get(i);
            }
        }
        return administrator;
    }
    public R<Administrator> findByRAno(String ano){
        List<Administrator> administrators = administratorRepository.findAll();
        Administrator administrator = new Administrator();
        for (int i = 0;i < administrators.size();i++){
            if (ano.equals(administrators.get(i).getAno())){
                administrator = administrators.get(i);
            }
        }
        R<Administrator> RAll = new R<>();
        RAll.setData(administrator);
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setMsg(REnum.SUCCESS.getMsg());
        return RAll;
    }

    /**
     * 以年龄查询管理员
     * @param age
     * @return 返回List
     */
    public List<Administrator> findByAge(Integer age){
        List<Administrator> administrators = administratorRepository.findAll();
        List<Administrator> administratorsNew = new ArrayList<>();
        for (int i = 0;i < administrators.size();i++){
            if (age == administrators.get(i).getAge()){
                administratorsNew.add(administrators.get(i));
            }
        }
        return administratorsNew;
    }
    public R<List<Administrator>> findByRAge(Integer age){
        List<Administrator> administrators = administratorRepository.findAll();
        List<Administrator> administratorsNew = new ArrayList<>();
        for (int i = 0;i < administrators.size();i++){
            if (age == administrators.get(i).getAge()){
                administratorsNew.add(administrators.get(i));
            }
        }
        R<List<Administrator>> RAll = new R<>();
        RAll.setData(administratorsNew);
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setMsg(REnum.SUCCESS.getMsg());
        return RAll;
    }

    /**
     * 以性别查询管理员
     * @param sex
     * @return 返回List
     */
    public List<Administrator> findBySex(String sex){
        List<Administrator> administrators = administratorRepository.findAll();
        List<Administrator> administratorsNew = new ArrayList<>();
        for (int i = 0;i < administrators.size();i++){
            if (sex.equals(administrators.get(i).getSex())){
                administratorsNew.add(administrators.get(i));
            }
        }
        return administratorsNew;
    }
    public R<List<Administrator>> findByRSex(String sex){
        List<Administrator> administrators = administratorRepository.findAll();
        List<Administrator> administratorsNew = new ArrayList<>();
        for (int i = 0;i < administrators.size();i++){
            if (sex.equals(administrators.get(i).getSex())){
                administratorsNew.add(administrators.get(i));
            }
        }
        R<List<Administrator>> RAll = new R<>();
        RAll.setData(administratorsNew);
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setMsg(REnum.SUCCESS.getMsg());
        return RAll;
    }

    /**
     * 姓名密码查询管理员
     * @param name
     * @param password
     * @return
     */
    public Administrator findByNameAndPassword(String name,String password){
        List<Administrator> administrators = administratorRepository.findAll();
        Administrator administrator = new Administrator();
        for (int i = 0;i < administrators.size();i++){
            if (name.equals(administrators.get(i).getAname()) && password.equals(administrators.get(i).getPassword())){
                administrator = administrators.get(i);
                break;
            }
        }
        return administrator;
    }
    public R<Administrator> findByRNameAndPassword(String name,String password){
        List<Administrator> administrators = administratorRepository.findAll();
        Administrator administrator = new Administrator();
        for (int i = 0;i < administrators.size();i++){
            if (name.equals(administrators.get(i).getAname()) && password.equals(administrators.get(i).getPassword())){
                administrator = administrators.get(i);
                break;
            }
        }
        R<Administrator> RAll = new R<>();
        RAll.setData(administrator);
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setMsg(REnum.SUCCESS.getMsg());
        return RAll;
    }

    /**
     * 工号密码查询管理员
     * @param Ano
     * @param password
     * @return
     */
    public Administrator findByAnoAndPassword(String Ano,String password){
        List<Administrator> administrators = administratorRepository.findAll();
        Administrator administrator = new Administrator();
        for (int i = 0;i < administrators.size();i++){
            if (Ano.equals(administrators.get(i).getAno()) && password.equals(administrators.get(i).getPassword())){
                administrator = administrators.get(i);
                break;
            }
        }
        return administrator;
    }
    public R<Administrator> findByRAnoAndPassword(String ano,String password){
        List<Administrator> administrators = administratorRepository.findAll();
        Administrator administrator = new Administrator();
        for (int i = 0;i < administrators.size();i++){
            if (ano.equals(administrators.get(i).getAno()) && password.equals(administrators.get(i).getPassword())){
                administrator = administrators.get(i);
                break;
            }
        }
        R<Administrator> RAll = new R<>();
        RAll.setData(administrator);
        RAll.setCode(REnum.SUCCESS.getCode());
        RAll.setMsg(REnum.SUCCESS.getMsg());
        return RAll;
    }

    /**
     * 管理员信息的增加
     * @param administrator
     * @return 返回Administrator
     */
    public Administrator insert(Administrator administrator){
        administratorRepository.save(administrator);
        return administrator;
    }

    /**
     * 管理员信息的更新
     * @param administrator
     * @return
     */
    public Administrator update(Administrator administrator){
        administratorRepository.save(administrator);
        return administrator;
    }

    /**
     * 管理员信息通过id删除
     * @param id
     */
    public void deleteId(Integer id){
        administratorRepository.deleteById(id);
    }
}
