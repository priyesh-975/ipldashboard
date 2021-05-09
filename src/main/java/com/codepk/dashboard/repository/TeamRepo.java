package com.codepk.dashboard.repository;

 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codepk.dashboard.model.Team;

@Repository
public interface TeamRepo extends CrudRepository<Team,Long> {
	
	Team findByteamName(String teamName);

}
