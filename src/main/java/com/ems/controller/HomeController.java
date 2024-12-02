package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ems.entity.Employee;
import com.ems.service.EmpService;


import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private EmpService empService;
	
	
	@GetMapping("/")
	public String index(Model m) {
		List<Employee> list=empService.getAllEmp();
		m.addAttribute("empList", list);
		return "index";
	}
	
	
	@GetMapping("/loadEmpSave")
	public String loadEmpSave() {
		return "emp_save";
	}
	
	@GetMapping("/editEmp/{id}")
	public String editEmp(@PathVariable int id, Model m) {
		//System.out.println(id);
		Employee emp=empService.getEmpByid(id);
		m.addAttribute("emp",emp);
		return "edit_emp";
	}
	
	
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee emp, HttpSession session) {
		Employee employee=empService.saveEmp(emp);
		if(employee!=null) {
			session.setAttribute("msg", "Employee Registered successfully");
		}
		else {
			session.setAttribute("msg","OOPS!... Something went wrong on the server");
		}
		return "redirect:/loadEmpSave";
	}
	
	
	
	@PostMapping("/updateEmp")
	public String updateEmp(@ModelAttribute Employee emp, HttpSession session) {
		Employee updateEmployee=empService.saveEmp(emp);
		if(updateEmployee!=null) {
			session.setAttribute("msg", "Employee Updated successfully");
		}
		else {
			session.setAttribute("msg","OOPS!... Something went wrong on the server");
		}
		return "redirect:/";
	}
	
	@GetMapping("/deleteEmp/{id}")
	public String loadEmpSave(@PathVariable int id, HttpSession session) {
		boolean f=empService.deleteEmp(id);
		if(f) {
			session.setAttribute("msg", "Employee deleted successfully");
		}
		else {
			session.setAttribute("msg","OOPS!... Something went wrong on the server");
		}
		return "redirect:/";
	}
	
	
}
