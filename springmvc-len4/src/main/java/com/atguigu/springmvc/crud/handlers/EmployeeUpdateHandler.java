package com.atguigu.springmvc.crud.handlers;

import com.atguigu.springmvc.crud.dao.DepartmentDao;
import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EmployeeUpdateHandler {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentDao departmentDao;


    /**
     *  4-1 修改保存员工用的
     *  @ModelAttribute 方法
     */
    @ModelAttribute
    public void getEmployee(
            @RequestParam(value="id",required=false) Integer id,
            Map<String, Object> map){

        System.out.println("@ModelAttribute修饰的方法执行了! id=" + id);
        if(id != null){
            map.put("employee", employeeDao.get(id));
        }
    }

    /**
     *  4-2 进入修改员工页面 update.jsp       区分下面一个input方法
     */
    @RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
    public String input(@PathVariable("id") Integer id, Map<String, Object> map){
        Map<String, String> genders = new HashMap<String,String>();
        genders.put("1", "Male");
        genders.put("0", "Female");
        map.put("genders", genders);
        //对应update.jsp form表单的employee
        map.put("employee", employeeDao.get(id));
        map.put("departments", departmentDao.getDepartments()); //同上
        return "update";
    }

    /**
     * 4-3 修改保存员工
     */
    @RequestMapping(value="/emp", method=RequestMethod.PUT)
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }



}
