package com.codepk.dashboard.repository;

 
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codepk.dashboard.model.Match;
import com.codepk.dashboard.model.Team;

@Repository
public interface MatchRepo extends CrudRepository<Match,Long> {
	
	List<Match> getByTeam1OrTeam2OrderByDateDesc(String team1,String team2,Pageable pageable);
	
	default List<Match> getLatestMatchByTeam(String teamName,int count)
	{
		return getByTeam1OrTeam2OrderByDateDesc(teamName,teamName,PageRequest.of(0, count));
	}
}
