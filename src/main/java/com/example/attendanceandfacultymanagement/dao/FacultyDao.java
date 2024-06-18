package com.example.attendanceandfacultymanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.attendanceandfacultymanagement.entity.Course;
import com.example.attendanceandfacultymanagement.entity.Faculty;

@Repository
public class FacultyDao {
	@Autowired
	SessionFactory factory;

	public boolean createFaculty(Faculty faculty) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(faculty);
		transaction.commit();
		session.close();
		return true;
	}

	public List<Faculty> getAllFaculties() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Faculty.class);
		List<Faculty> list = criteria.list();
		session.close();
		return list;
	}

	public Faculty getFacultyById(long id) {
		Session session = factory.openSession();
		Faculty faculty =session.get(Faculty.class, id);
		session.close();
		return faculty;
	}

	public boolean updateFaculty(long id, Faculty faculty) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Faculty facultyold =session.get(Faculty.class, id);
		if( facultyold!=null) {
			facultyold.setEmail(faculty.getEmail());
			session.update(facultyold);
		}
		transaction.commit();
		session.close();
		return true;
	}

	public boolean deleteFacultyByid(long id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Faculty faculty =session.get(Faculty.class, id);
		if( faculty!=null) {
			session.delete(faculty);
		}
		transaction.commit();
		session.close();
		return true;
	}

}
