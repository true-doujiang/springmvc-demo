package com.atguigu.springmvc.crud.entities;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class Employee {

	private Integer id;

	@NotEmpty
	private String lastName;

	@Email
    @NotEmpty//即不能为空还必须是合法邮件地址
	private String email;

	private Integer gender;  //1 male, 0 female
	private Department department;

    /**
     * 新加这俩个属性测试数据类型格式化、参数校验jsr303
     */
    @Past
    @DateTimeFormat(pattern="yyyy-MM-dd") //表单输入的时候验按照这个格式要求   数据格式化注解
    private Date birth;
    @NumberFormat(pattern="#,###,###.#")  //#代表一位数字   数据格式化注解
    private Float salary;

	
	public Employee() { }
	
	public Employee(Integer id, String lastName, String email, Integer gender,
			Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}

    public Employee(Integer id, String lastName, String email, Integer gender, Department department, Date birth, Float salary) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = birth;
        this.salary = salary;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email="
				+ email + ", gender=" + gender + ", department=" + department
				+ ", birth=" + birth + ", salary=" + salary + "]";
	}


}
