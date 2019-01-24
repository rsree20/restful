package com.rest.services.impl;

import javax.ws.rs.core.Response;

import com.rest.exception.DaoException;
import com.rest.pojo.IplResponse;
import com.rest.pojo.Team;
import com.rest.services.dao.IplDaoInterf;
import com.rest.services.dao.impl.IplDaoImpl;

public class IplServiceImpl {

	public Response registerTeam(Team team) {
		IplResponse res = new IplResponse();
		
		if(team.getTeamName() == null) {
			res.setErrorCode("002");
			res.setErrorMessage("Team Name should not be null");
			return Response.status(200).entity(res).build();
		}
		
		if(team.getTotalMatches() <= 0) {
			res.setErrorCode("003");
			res.setErrorMessage("Matches played(Total Matches) should not be lessthen zero!! You should have some experience to register ipl!!");
			return Response.status(200).entity(res).build();
		}
		
		double winPercent = (team.getWins()/team.getTotalMatches())*100;
		
		if(winPercent >=50) {
			System.out.println("Team has morethan 50% win percent");
			team.setStatus("Accepted");
			System.out.println("Save team to database");
			IplDaoInterf dao = new IplDaoImpl();
			try {
				dao.registerTeam(team);				
			} catch(DaoException daoEx) {
				res.setErrorCode("001");
				res.setErrorMessage(daoEx.getMessage());
				res.setTeam(null);
				return Response.status(200).entity(res).build();
			}
			//Team is accepted hence save team details in db
		}
		res.setErrorCode("000");
		res.setErrorMessage("success");
		res.setTeam(team);
		//If team is accepted make a entry in db
		return Response.status(200).entity(res).build();
	}
}
