package com.example.attendanceandfacultymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendanceandfacultymanagement.dao.FacultyDao;
import com.example.attendanceandfacultymanagement.entity.Faculty;

@Service
public class FacultyService {
	
	@Autowired
	FacultyDao dao;

	public String createfaculty(Faculty faculty) {
		if(dao.createFaculty(faculty)){
			return "faculty created sucessfully";
		}
		else{
			return "faculty not created";
		}
	}

	public List<Faculty> getAllFaculties() {
		if(dao.getAllFaculties()!=null){
			return dao.getAllFaculties();
		}
		else{
			return null;
		}
	}

	public Faculty getFacultyById(long id) {
		if(dao.getFacultyById(id)!=null){
			return dao.getFacultyById(id);
		}
		else{
			return null;
		}
	}

	public String updateFaculty(long id, Faculty faculty) {
		if(dao.updateFaculty(id, faculty)){
			return "faculty updated sucessfully";
		}
		else{
			return "faculty not updated";
		}
	}

	public String deleteFacultyByid(long id) {
		if(dao.deleteFacultyByid( id)){
			return "faculty deleted sucessfully";
		}
		else{
			return "faculty not deleted";
		}
	}

}
