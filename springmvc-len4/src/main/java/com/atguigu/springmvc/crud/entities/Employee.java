package com.atguigu.springmvc.crud.entities;

import java.util.Date;

public class Employee {

	private Integer id;
	private String lastName;
	private String email;
	private Integer gender;  //1 male, 0 female
	private Department department;
//	private Date birth;
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
//
//	public Date getBirth() {
//		return birth;
//	}
//
//	public void setBirth(Date birth) {
//		this.birth = birth;
//	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}
//
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", lastName=" + lastName + ", email="
//				+ email + ", gender=" + gender + ", department=" + department
//				+ ", birth=" + birth + ", salary=" + salary + "]";
//	}


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
