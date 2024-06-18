package com.example.attendanceandfacultymanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.attendanceandfacultymanagement.entity.Department;

@Repository
public class DepartmentDao {

	@Autowired
	SessionFactory factory;

	public boolean createDepartment(Department department) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(department);
		transaction.commit();
		session.close();
		return true;
	}

	public List<Department> getAllDepartments() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Department.class);
		List<Department> department = criteria.list();
		transaction.commit();
		session.close();
		return department;
	}

	public Department getDepById(long id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Department department =session.get(Department.class, id);
		transaction.commit();
		session.close();
		return department;
	}

	public boolean updateDep(long id, Department department) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Department existingdepartment =session.get(Department.class, id);
		if(existingdepartment!=null) {
			existingdepartment.setName(department.getName());	
			session.update(existingdepartment);
			}
		transaction.commit();
		session.close();
		return true;
	}

	public boolean deleteDepById(long id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Department existingdepartment =session.get(Department.class, id);
		if(existingdepartment!=null) {	
			session.delete(existingdepartment);
			}
		transaction.commit();
		session.close();
		return true;
	}
}
