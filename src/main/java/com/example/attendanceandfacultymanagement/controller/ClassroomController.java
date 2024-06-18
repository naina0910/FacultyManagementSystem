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
import com.example.attendanceandfacultymanagement.service.ClassroomService;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

	@Autowired
	ClassroomService service;
	
	@PostMapping("/createclassroom")
	public String createClassroom(@RequestBody Classroom classroom) {
		return service.createClassroom(classroom);
	}
	
	@GetMapping("/get-all-classroom")
	public List<Classroom> getAllClassrooms() {
		return service.getAllClassrooms();
	}
	
	@GetMapping("/get-classroom-by-id/{id}")
	public Classroom getClassroomByd(@PathVariable long id) {
		return service. getClassroomByd(id);
	}
	
	@PutMapping("/update-classroom/{id}")
	public String updateClassroom(@PathVariable long id,@RequestBody Classroom classroom) {
		return service.updateClassroom(id,classroom);
	}
	
	@DeleteMapping("/delete-by-id/{id}")
	public String deleteClassroomById(@PathVariable long id) {
		return service.deleteClassroomById( id);
	}
	
}
