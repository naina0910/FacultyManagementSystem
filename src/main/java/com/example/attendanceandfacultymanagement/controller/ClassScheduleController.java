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

import com.example.attendanceandfacultymanagement.entity.ClassSchedule;
import com.example.attendanceandfacultymanagement.service.ClassSchedularService;


@RestController
@RequestMapping("/ClassSchedular")
public class ClassScheduleController 
{
   @Autowired
   private ClassSchedularService classSchedularService;
   
   @PostMapping("createClassSchedular")
   public String createClassSchedular(@RequestBody ClassSchedule classSchedule)
   {
	   return classSchedularService.createClassSchedular(classSchedule);
   }
   @GetMapping("/getAllSchedular")
   public void getAllSchedular()
   {
	   classSchedularService.getAllSchedular();
   }
   @GetMapping("/getSchedularById/{id}")
   public List<ClassSchedule> getSchedularById(@PathVariable long id)
   {
	  return  classSchedularService.getSchedularById(id);
   }
   @PutMapping("/updateSchedular/{id}/{dayOfWeek}")
   public String updateSchedular(@PathVariable long id,@PathVariable String dayOfWeek)
   {
	  return  classSchedularService.updateSchedular(id,dayOfWeek);
   }
   
   @DeleteMapping("/deleteSchedular/{id}")
   public String deleteSchedular(@PathVariable long id)
   {
	  return classSchedularService.deleteSchedular(id);
   }
}
