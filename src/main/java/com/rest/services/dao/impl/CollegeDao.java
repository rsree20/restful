package com.rest.services.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rest.exception.DaoException;
import com.rest.pojo.Student;

public class CollegeDao {

	static SessionFactory sf;
	static {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
	}
	
	public void saveStudent(Student s) throws DaoException {
	
		try {
			Session session = sf.openSession();
			System.out.println(10/0);
			session.save(s);
		} catch (Exception e) {
			throw new DaoException("Something went wrong with Database");
		}
		
	}
}
