package com.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.rest.exception.DaoException;
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
		IplResponse res = new IplResponse();
		Gson gson = new Gson();
		
		if(s.getStdId() == 0) {
			res.setErrorCode("001");
			res.setErrorMessage("Student Id should not be empty or null");
			return Response.status(200).entity(res).build();
		}
		
		if(s.getCollegeName().equalsIgnoreCase("Aurora")) {
			if(s.getStdId() < 1 || s.getStdId() > 999) {
				res.setErrorCode("005");
				res.setErrorMessage("This student id is not valid for your college!!");
				return Response.status(200).entity(res).build();
			}
		}
		
		if(s.getCollegeName().equalsIgnoreCase("CBIT")) {
			if(s.getStdId() < 1000 || s.getStdId() > 9999) {
				res.setErrorCode("005");
				res.setErrorMessage("This student id is not valid for your college!!");
				return Response.status(200).entity(res).build();
			}
		}
		
		if(s.getCollegeName().equalsIgnoreCase("GRIT")) {
			if(s.getStdId() < 10000 || s.getStdId() > 19999) {
				res.setErrorCode("005");
				res.setErrorMessage("This student id is not valid for your college!!");
				return Response.status(200).entity(res).build();
			}
		}
		
		//Hibernate/jdbc logic......
		
		CollegeDao dao = new CollegeDao();
		try {
			dao.saveStudent(s);
		} catch (DaoException e) {
			res.setErrorCode("003");
			res.setErrorMessage(e.getMessage());
			return Response.status(200).entity(res).build();
		}
		
		res.setErrorCode("000");
		res.setErrorMessage("success");
		res.setResponseData(gson.toJson(s));
		
		return Response.status(200).entity(res).build();
	}
	
	@Path("/saveTeacher")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addTeacher(Teacher t) {
		IplResponse res = new IplResponse();
		Gson gson = new Gson();
		
		if(t.getTeacherId() == 0) {
			res.setErrorCode("002");
			res.setErrorMessage("Teacher Id should not be empty or null");
			return Response.status(200).entity(res).build();
		}
		
		//Hibernate/jdbc logic......
		res.setErrorCode("000");
		res.setErrorMessage("success");
		res.setResponseData(gson.toJson(t));
		
		return Response.status(200).entity(res).build();
	}
	
}
