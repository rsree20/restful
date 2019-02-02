package com.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hibernate.hql.internal.ast.ErrorReporter;
import org.omg.CORBA.RepositoryIdHelper;

import com.google.gson.Gson;
import com.rest.exception.DaoException;
import com.rest.pojo.ExceptionRespone;
import com.rest.pojo.IplResponse;
import com.rest.pojo.Student;
import com.rest.pojo.Teacher;
import com.rest.services.dao.impl.CollegeDao;

@Path("/college")
public class CollegeService {

	@Path("/saveStudent")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addStudent(Student s) {
		ExceptionRespone response = new ExceptionRespone();
		Gson gson = new Gson();
		
		if(s.getStdId() == 0) {
			response.setErrorCode("001");
			response.setErrorMessage("Student Id should not be empty or null");
			return Response.status(500).entity(response).build();
		}
		
		if(s.getCollegeName().equalsIgnoreCase("Aurora")) {
			if(s.getStdId() < 1 || s.getStdId() > 999) {
				response.setErrorCode("005");
				response.setErrorMessage("This student id is not valid for your college!!");
				return Response.status(500).entity(response).build();
			}
		}
		
		if(s.getCollegeName().equalsIgnoreCase("CBIT")) {
			if(s.getStdId() < 1000 || s.getStdId() > 9999) {
				response.setErrorCode("005");
				response.setErrorMessage("This student id is not valid for your college!!");
				return Response.status(500).entity(response).build();
			}
		}
		
		if(s.getCollegeName().equalsIgnoreCase("GRIT")) {
			if(s.getStdId() < 10000 || s.getStdId() > 19999) {
				response.setErrorCode("005");
				response.setErrorMessage("This student id is not valid for your college!!");
				return Response.status(500).entity(response).build();
			}
		}
		
		//Hibernate/jdbc logic......
		
		CollegeDao dao = new CollegeDao();
		try {
			dao.saveStudent(s);
		} catch (DaoException e) {
			response.setErrorCode("003");
			response.setErrorMessage(e.getMessage());
			return Response.status(500).entity(response).build();
		}
		
		return Response.status(200).entity(s).build();
	}
	
	@Path("/saveTeacher")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addTeacher(Teacher t) {
		ExceptionRespone errorRes = new ExceptionRespone();
		
		if(t.getName() == null || t.getName().isEmpty()) {
			errorRes.setErrorCode("006");
			errorRes.setErrorMessage("Teacher Name should not be null or empty!!");
			return Response.status(500).entity(errorRes).build();
		}
		
		CollegeDao dao = new CollegeDao();
		try {
			dao.saveTeacher(t);
		} catch (DaoException e) {
			e.printStackTrace();
			errorRes.setErrorCode("003");
			errorRes.setErrorMessage(e.getMessage());
			return Response.status(500).entity(errorRes).build();
		}
		
		return Response.status(201).entity(t).build();
	}
	
}
