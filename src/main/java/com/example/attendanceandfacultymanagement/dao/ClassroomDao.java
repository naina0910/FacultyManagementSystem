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

@Repository
public class ClassroomDao {
    @Autowired
	SessionFactory factory;
	public boolean createClassroom(Classroom classroom) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(classroom);
		transaction.commit();
		session.close();
		return true;
	}
	public List<Classroom> getAllClassrooms() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Classroom.class);
		List<Classroom> classroom =criteria.list();
	    transaction.commit();
		session.close(); 
		return classroom;
	}
	public Classroom getClassroomByd(long id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Classroom.class);
		criteria.add(Restrictions.eq("id", id));
		Classroom classroom =(Classroom) criteria.uniqueResult();
	    transaction.commit();
		session.close(); 
		return classroom;
	}
	public boolean updateClassroom(long id, Classroom classroom) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		  Classroom existingclassroom = session.get(Classroom.class,id);
	        if (existingclassroom!= null) {
	        	existingclassroom.setName(classroom.getName());
	            
	            session.update(existingclassroom);
	        }
		
		transaction.commit();
		
		return true;
	}
	public boolean deleteClassroomById(long id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		  Classroom classroom = session.get(Classroom.class,id);
	        if (classroom!= null) {
	        	session.delete(classroom);
	        }
		
		transaction.commit();
		
		return true;
	}

}
