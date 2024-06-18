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

import com.example.attendanceandfacultymanagement.entity.Subject;
import com.example.attendanceandfacultymanagement.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController 
{
   @Autowired
   private SubjectService subjectService;
   
   @PostMapping("/insertSubject")
   public String insertSubject(@RequestBody Subject subject)
   {
	   return subjectService.insertSubject(subject);
   }
	
	@GetMapping("/getAllSubject")
   public List<Subject> getAllSubject()
   {
	   return subjectService.getAllSubject();
   }
	
   @GetMapping("/getSubjectById/{id}")
   public List<Subject>getSubjectById(@PathVariable long id)
   {
	  return  subjectService.getSubjectById(id);
   }
	
   @PutMapping("/updateSubject/{id}/{name}")
   public String updateSubject(@PathVariable long id,@PathVariable String email)
   {
	  return  subjectService.updateSubject(id,email);
   }
   
   @DeleteMapping("/deleteSubject/{id}")
   public String deleteSubject(@PathVariable long id)
   {
	  return subjectService.deleteSubject(id);
   }
}
