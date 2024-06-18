package com.example.attendanceandfacultymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendanceandfacultymanagement.dao.ClassroomDao;
import com.example.attendanceandfacultymanagement.entity.Classroom;

@Service
public class ClassroomService {

	@Autowired
	ClassroomDao dao;
	public String createClassroom(Classroom classroom) {
		if(dao.createClassroom( classroom)) {
			return "classroom created succesfully";
		}
		else {
			return "classroom not created";
		}
	}
	public List<Classroom> getAllClassrooms() {
		if(dao.getAllClassrooms()!=null) {
		return dao.getAllClassrooms();
		}
		else {
			return null;
		}
	}
	public Classroom getClassroomByd(long id) {
		if(dao.getClassroomByd(id)!=null) {
			return dao.getClassroomByd(id);
			}
			else {
				return null;
			}
		
	}
	public String updateClassroom(long id, Classroom classroom) {
		// TODO Auto-generated method stub
		if(dao.updateClassroom(id,classroom)) 
		{
			return "Updated succesfully";
			}
		else {
			return "Not updated";
		}
	}
	public String deleteClassroomById(long id) {
		if(dao.deleteClassroomById(id)) {
		return "Classroom deleted successfully";
	}else {
		return "Classroom not deleted ";
	}
	}

}
