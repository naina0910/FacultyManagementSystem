package com.example.attendanceandfacultymanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.attendanceandfacultymanagement.entity.Classroom;
import com.example.attendanceandfacultymanagement.entity.Course;

@Repository
public class CourseDao {
    
	@Autowired
	SessionFactory factory;
	
	public boolean createCourse(Course course) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(course);
		transaction.commit();
		session.close();
		return true;
	}

	public List<Course> getAllCourses() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Course.class);
		List<Course> list = criteria.list();
		session.close();
		return list;
	}

	public Course getCourseById(long id) {
		Session session = factory.openSession();
		Course course =session.get(Course.class, id);
		session.close();
		return course;
	}

	public boolean updatecourse(long id,Course course) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		 Course existingcourse = session.get(Course.class,id);
		
		if(existingcourse!=null) {
			existingcourse.setName(course.getName());
			session.update(existingcourse);
		}
		transaction.commit();
		session.close();
		return true;
	}

	public boolean deleteCourseByid(long id) {
		// TODO Auto-generated method stub
				Session session = factory.openSession();
				Transaction transaction = session.beginTransaction();
				 Course existingcourse = session.get(Course.class,id);
				 if(existingcourse!=null) {
					 session.delete(existingcourse);
				 }
				 transaction.commit();
					session.close();
					return true;
	}

}
