package com.example.attendanceandfacultymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendanceandfacultymanagement.dao.SubjectDao;
import com.example.attendanceandfacultymanagement.entity.Subject;


@Service
public class SubjectService
{
  @Autowired
  private SubjectDao subjectDao;
  
  public String insertSubject(Subject subject)
  {
	  if(subjectDao.insertSubject(subject))
	  {
		  return "subject inserted successfully";
	  }
	  else
	  {
		  return "subject is not inserted";
	  }
  }
  
  public List<Subject> getAllSubject() {
	   if(subjectDao. getAllSubject()!=null)
	   {
		   return subjectDao. getAllSubject();
	   }
	   else
	   {
		   return null;
	   }
  }

	public List<Subject> getSubjectById(long id) 
	{
		if(subjectDao.getSubjectById(id)!=null)
		{
			return subjectDao.getSubjectById(id);
		}
		else
		{
			return null;
		}
	}

	public String updateSubject(long id, String name) {
		if(subjectDao.updateSubject(id,name))
		{
			return "faculty updated successfully";
		}
		else
		{
			return "faculty not updated";
		}
	}

	public String deleteSubject(long id) {
		if(subjectDao.deleteSubject(id))
		{
			return "faculty is deleted";
		}
		else
		{
			return "faculty is not deleted";
		}
	}

}
