package com.rest.services.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rest.exception.DaoException;
import com.rest.pojo.Student;
import com.rest.pojo.Teacher;

public class CollegeDao {

	static SessionFactory sf;
	static {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
	}
	
	public void saveStudent(Student s) throws DaoException {
	
		try {
			Session session = sf.openSession();
			session.save(s);
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Something went wrong with Database");
		}
		
	}

	public void saveTeacher(Teacher t) throws DaoException {
		try {
			Session session = sf.openSession();
			session.save(t);
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Something went wrong with database");
		}
		
	}
}
