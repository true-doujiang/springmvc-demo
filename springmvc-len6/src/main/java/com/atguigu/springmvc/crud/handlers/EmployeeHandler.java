package com.atguigu.springmvc.crud.handlers;

import com.atguigu.springmvc.crud.dao.DepartmentDao;
import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmployeeHandler {
	

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentDao departmentDao;


    //****************@InitBinder注解*********************//
    //@InitBinder标识的方法,可以对 WebDataBinder对象进行初始化
//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//        //数据绑定是忽略lastName属性
//		binder.setDisallowedFields("lastName");
//	}
	
    /**
     *  1 查找所有员工
     */
	@RequestMapping("/emps")
	public String list(Map<String, Object> map){
		map.put("employees", employeeDao.getAll());
		return "list";
	}

    /**
     * 2-1 进入添加员工信息页面input.jsp 必须经过此hander
     */
    @RequestMapping(value="/emp", method=RequestMethod.GET)
    public String input(Map<String, Object> map){

        Map<String, String> genders = new HashMap<>();
        genders.put("1", "Male");
        genders.put("0", "Female");
        map.put("genders", genders);
        //对应input.jsp form表单的Department
        map.put("departments", departmentDao.getDepartments());
        //对应input.jsp form表单的modelAttribute属性,用户回显
        map.put("employee", new Employee());
        return "input";
    }

    /**
     * 2-2 保存员工方法
     *
     * 需校验的 Bean(Employee)对象和其绑定结果对象(Errors)或错误对象时成对出现的，它们之间不允许声明其他的入参
     */
    @RequestMapping(value="/emp", method=RequestMethod.POST)
    public String save(@Valid Employee employee, Errors result, Map<String, Object> map){
        System.out.println("save: " + employee);

        if(result.getErrorCount() > 0){
            for(FieldError error:result.getFieldErrors()){
                System.out.println(error.getField() + ":" + error.getDefaultMessage());
            }
            Map<String, String> genders = new HashMap<>();
            genders.put("1", "Male");
            genders.put("0", "Female");
            map.put("genders", genders);
            map.put("departments", departmentDao.getDepartments());
            return "input";  //若验证出错, 则转向定制的页面
        }

        employeeDao.save(employee);
        //重定向到首页面
        return "redirect:/emps";
    }


    /**
     * 3 删除员工
     */
    @RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }


}
