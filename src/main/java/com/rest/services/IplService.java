package com.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.pojo.Score;
import com.rest.pojo.Team;

@Path("/ipl")
public class IplService {

	@Path("/testConnection")
	@GET
	public Response testConnection() {
		System.out.println("test connection success!!");
		return Response.status(200).entity("success").build();
	}
	
	@Path("/testAgain")
	@GET
	public Response testAgain() {
		System.out.println("test connection success again!!");
		return Response.status(201).entity("success again").build();
	}
	
	@Path("/getScore")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getScore() {
		System.out.println("Requested for score!!");
		Score score = new Score();
		score.setCountryName("India");
		score.setRuns(340);
		score.setWickets(6);
		score.setOvers(92.4);
		score.setBat1("Virat");
		score.setBat2("Jadeja");
		
		return Response.status(200).entity(score).build();
	}
	
	@Path("/registerForIpl")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerTeam(Team team) {
		System.out.println("Requested for registration " + team.getTeamName());
		
		double winPercent = (team.getWins()/team.getTotalMatches())*100;
		if(winPercent >=50) {
			System.out.println("Team has morethan 50% win percent");
			team.setStatus("Accepted");
			//Team is accepted hence save team details in db
		}
		
		//If team is accepted make a entry in db
		return Response.status(201).entity(team).build();
	}
	
}