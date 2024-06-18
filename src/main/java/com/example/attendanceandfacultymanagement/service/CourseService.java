package com.example.attendanceandfacultymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendanceandfacultymanagement.dao.CourseDao;
import com.example.attendanceandfacultymanagement.entity.Classroom;
import com.example.attendanceandfacultymanagement.entity.Course;

@Service
public class CourseService {
	
	@Autowired
	CourseDao dao;

	public String createCourse(Course course) {
		// TODO Auto-generated method stub
		if(dao.createCourse(course)){
			return "Course created sucessfully";
		}
		else{
			return "Course not created";
		}
	}

	public List<Course> getAllCourses() {
		if(dao.getAllCourses()!=null){
			return dao.getAllCourses();
		}
		else{
			return null;
		}

	}

	public Course getCourseById(long id) {
		if(dao.getCourseById(id)!=null){
			return dao.getCourseById(id);
		}
		else{
			return null;
		}
	}

	public String updatecourse(long id, Course course) {
		if(dao.updatecourse(id ,course)){
			return "Course update sucessfully";
		}
		else{
			return "Course not updated";
		}
	}

	public String deleteCourseByid(long id) {
		if(dao.deleteCourseByid(id )){
			return "Course deleted sucessfully";
		}
		else{
			return "Course not deleted";
		}
	}

}
