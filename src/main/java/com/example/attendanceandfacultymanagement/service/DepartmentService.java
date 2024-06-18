package com.example.attendanceandfacultymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendanceandfacultymanagement.dao.DepartmentDao;
import com.example.attendanceandfacultymanagement.entity.Department;

@Service
public class DepartmentService {

	@Autowired
	DepartmentDao dao;

	public String createDepartment(Department department) {
		if (dao.createDepartment(department)) {
			return "department created successfully";
		} else {
			return "department not created";
		}
	}

	public List<Department> getAllDepartments() {
		if (dao.getAllDepartments() != null) {
			return dao.getAllDepartments();
		} else {
			return null;
		}
	}

	public Department getDepById(long id) {
		if (dao.getDepById(id) != null) {
			return dao.getDepById(id);
		} else {
			return null;
		}
	}

	public String updateDep(long id, Department department) {

		if (dao.updateDep(id, department)) {
			return "department updated successfully";
		} else {
			return "department not updated";
		}
	}

	public String deleteDepById(long id) {
		if (dao.deleteDepById(id)) {
			return "department deleted successfully";
		} else {
			return "department not updated";
		}
	}

}
