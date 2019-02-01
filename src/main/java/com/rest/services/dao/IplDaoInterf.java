package com.rest.services.dao;

import com.rest.exception.DaoException;
import com.rest.pojo.Team;

public interface IplDaoInterf {

	public void registerTeam(Team team) throws DaoException;
}
