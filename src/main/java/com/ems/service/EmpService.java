package com.ems.service;

import java.util.List;

import com.ems.entity.Employee;

public interface EmpService {
	
	public Employee saveEmp(Employee emp);
	
	public List<Employee> getAllEmp();
	
	public Employee getEmpByid(int id);
	
	public boolean deleteEmp(int id);

}
