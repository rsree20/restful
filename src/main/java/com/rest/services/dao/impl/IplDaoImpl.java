package com.rest.services.dao.impl;

import java.sql.SQLIntegrityConstraintViolationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import com.rest.exception.DaoException;
import com.rest.pojo.Team;
import com.rest.services.dao.IplDaoInterf;

public class IplDaoImpl implements IplDaoInterf {

	static SessionFactory sf;
	static {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
	}
	
	public void registerTeam(Team team) {
		try {
			System.out.println("Open Session here");
			Session session = sf.openSession();
			session.save(team);
			session.beginTransaction().commit();
			System.out.println("commit transaction");
		}catch (ConstraintViolationException e) {
			System.out.println("User already exist");
			e.printStackTrace();
			throw new DaoException(11000, "Your already registered for ipl!! Please start practice!!");
		} catch(NullPointerException npe) {
			npe.printStackTrace();
			throw new DaoException(11002, "Operation performed on null!!");
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(11001, "Something went wrong in database!! Seems database is down.. Please try after some time!!");
		}

	}

}
