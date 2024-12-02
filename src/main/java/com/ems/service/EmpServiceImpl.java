package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ems.entity.Employee;
import com.ems.repository.EmpRepository;

import jakarta.servlet.http.HttpSession;


@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepository empRepository;
	
	@Override
	public Employee saveEmp(Employee emp) {
		Employee newWmp=empRepository.save(emp);
		return newWmp;
	}

	@Override
	public List<Employee> getAllEmp() {
		
		return empRepository.findAll();
	}

	@Override
	public Employee getEmpByid(int id) {
		return empRepository.findById(id).get();
	}

	@Override
	public boolean deleteEmp(int id) {
		Employee emp=empRepository.findById(id).get();
		if(emp!=null) {
			empRepository.delete(emp);
			return true;
		}
		return false;
	}
	
	public void removeSessionMessage() {
		HttpSession session=((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
	
		session.removeAttribute("msg");
	}
		
	

}
