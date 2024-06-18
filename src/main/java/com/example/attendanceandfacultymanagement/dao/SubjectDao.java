package com.example.attendanceandfacultymanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.attendanceandfacultymanagement.entity.Faculty;
import com.example.attendanceandfacultymanagement.entity.Subject;



@Repository
public class SubjectDao 
{
	@Autowired
	SessionFactory factory;

	public boolean insertSubject(Subject subject) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(subject);
		transaction.commit();
		return true;
	}
	
	public List<Subject> getAllSubject() {
		Session session=factory.openSession();
		Criteria criteria=session.createCriteria(Subject.class);
		return criteria.list();
	}
	public List<Subject> getSubjectById(long id) 
	{
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Subject.class);
		criteria.add(Restrictions.eq("id", id));
		transaction.commit();
		return criteria.list();
	}
	public boolean updateSubject(long id, String name) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Faculty.class);
		criteria.add(Restrictions.eq("id", id));
		List<Subject> result=criteria.list();
		for(Subject subject:result)
		{
			subject.setName(name);
			session.update(name);
		}
		transaction.commit();
		return true;
	}
	public boolean deleteSubject(long id) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Subject subject=session.get(Subject.class, id);
		if(subject!=null)
		{
			session.delete(subject);
		}
		transaction.commit();
		return true;
	}
}
