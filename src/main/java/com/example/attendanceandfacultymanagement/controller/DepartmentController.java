package com.example.attendanceandfacultymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.attendanceandfacultymanagement.entity.Department;
import com.example.attendanceandfacultymanagement.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	DepartmentService service;
	
	@PostMapping("/createdepartment")
	public String createDepartment(@RequestBody Department department) {
		return service.createDepartment(department);
		}
	
	@GetMapping("/get-all-departments")
	public List<Department> getAllDepartments() {
		return service. getAllDepartments();
	}
	
	@GetMapping("/get-dep-by-id/{id}")
	public Department getDepById(@PathVariable long id) {
		return service.getDepById(id);
	}
	
	@PutMapping("updatedepartment/{id}")
	public String updateDep(@PathVariable long id,@RequestBody Department department ) {
		return service.updateDep(id,department);
	}
	
	@DeleteMapping("delete-dep-by-id/{id}")
	public String deleteDepById(@PathVariable long id) {
		return service.deleteDepById(id);
	}
	
}
