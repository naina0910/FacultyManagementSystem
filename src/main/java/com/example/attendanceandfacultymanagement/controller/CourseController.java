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

import com.example.attendanceandfacultymanagement.entity.Classroom;
import com.example.attendanceandfacultymanagement.entity.Course;
import com.example.attendanceandfacultymanagement.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	@Autowired
	CourseService service;
	
	@PostMapping("/createcourse")
	public String createCourse(@RequestBody Course course) {
		return service.createCourse(course);
	}
	
	@GetMapping("/get-all-courses")
	public List<Course> getAllCourses() {
		return service.getAllCourses();
	}
	
	@GetMapping("get-course-by-id/{id}")
	public Course getCourseById(@PathVariable long id) {
		return service.getCourseById( id);
	}
	
	@PutMapping("updatecourse/{id}")
	public String updatecourse(@PathVariable long id,@RequestBody Course course ) {
		return service.updatecourse(id,course);
	}
	
	@DeleteMapping("deletecourse/{id}")
	public String deleteCourseByid(@PathVariable long id) {
		return service.deleteCourseByid(id);
	}
}
