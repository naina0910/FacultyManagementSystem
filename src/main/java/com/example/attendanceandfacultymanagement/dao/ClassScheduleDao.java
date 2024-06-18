package com.example.attendanceandfacultymanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.attendanceandfacultymanagement.entity.ClassSchedule;


@Repository
public class ClassScheduleDao 
{
	@Autowired
	SessionFactory factory;

	public boolean createClassSchedular(ClassSchedule classSchedule) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(classSchedule);
		transaction.commit();
		return true;
	}

	public List<ClassSchedule> getAllSchedular() {
		Session session=factory.openSession();
		Criteria criteria=session.createCriteria(ClassSchedule.class);
		return criteria.list();
	}

	public List<ClassSchedule> getSchedularById(long id) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(ClassSchedule.class);
		criteria.add(Restrictions.eq("id", id));
		transaction.commit();
		return criteria.list();
	}

	public boolean updateSchedular(long id,String dayOfWeek) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(ClassSchedule.class);
		criteria.add(Restrictions.eq("id", id));
		List<ClassSchedule> result=criteria.list();
		for(ClassSchedule classSchedule:result)
		{
			classSchedule.setDayOfWeek(dayOfWeek);
			session.update(dayOfWeek);
		}
		transaction.commit();
		return true;
	}

	public boolean deleteSchedular(long id) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		ClassSchedule classSchedule=session.get(ClassSchedule.class, id);
		if(classSchedule!=null)
		{
			session.delete(classSchedule);
		}
		transaction.commit();
		return true;
	}
}
