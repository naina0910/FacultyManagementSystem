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


import com.example.attendanceandfacultymanagement.entity.Faculty;
import com.example.attendanceandfacultymanagement.service.FacultyService;

@RestController
@RequestMapping("api/faculties")
public class FacultyController {

	@Autowired
	FacultyService service;

	@PostMapping("/createfaculty")
	public String createFaculty(@RequestBody Faculty faculty) {
		return service.createfaculty(faculty);
	}

	@GetMapping("/get-all-faculties")
	public List<Faculty> getAllFaculties() {
		return service.getAllFaculties();
	}
	
	@GetMapping("/get-faculty-by-id/{id}")
	public Faculty getFacultyById(@PathVariable long id) {
		return service.getFacultyById(id);
	}
	
	@PutMapping("updatefaculty/{id}")
	public String updateFaculty(@PathVariable long id,@RequestBody Faculty faculty ) {
		return service.updateFaculty(id,faculty);
	}
	
	@DeleteMapping("deletefaculty/{id}")
	public String deleteFacultyByid(@PathVariable long id) {
		return service.deleteFacultyByid(id);
	}
	
}
