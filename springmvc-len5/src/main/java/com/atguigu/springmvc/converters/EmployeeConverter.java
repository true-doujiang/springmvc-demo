package com.atguigu.springmvc.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.atguigu.springmvc.crud.entities.Department;
import com.atguigu.springmvc.crud.entities.Employee;

/**
	可以利用 ConversionServiceFactoryBean 在Spring的 IOC容器中定义一个
 ConversionService. Spring将自动识别出IOC容器中的 ConversionService。
 */
//自定义类型转换器 要配置ConversionServiceFactoryBean的 converters属性
@Component
public class EmployeeConverter implements Converter<String, Employee> {

	@Override
	public Employee convert(String source) {
		if(source != null){
			String [] vals = source.split("-");  //GG-gg@atguigu.com-0-105
			if(vals != null && vals.length == 4){
				String lastName = vals[0];
				String email = vals[1];
				Integer gender = Integer.parseInt(vals[2]);
				Department department = new Department();
				department.setId(Integer.parseInt(vals[3]));
				
				Employee employee = new Employee(null, lastName, email, gender, department);
				System.out.println(source + "===convert===>" + employee);
				return employee;
			}
		}
		return null;
	}

}
