package com.codepk.dashboard.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codepk.dashboard.model.Team;
import com.codepk.dashboard.repository.MatchRepo;
import com.codepk.dashboard.repository.TeamRepo;

@RestController
@CrossOrigin
public class TeamController {
	
	
	private TeamRepo teamrepo;
	private MatchRepo matchrepo;
	
	public TeamController(TeamRepo teamrepo,MatchRepo matchrepo)
	{
		this.teamrepo=teamrepo;
		this.matchrepo=matchrepo;
	}
	
	
	@GetMapping("team/{teamName}")
	public Team getTeam(@PathVariable String teamName)
	{
		Team team= this.teamrepo.findByteamName(teamName);
		team.setMatches(this.matchrepo.getLatestMatchByTeam(teamName, 4));
		return team;
	}
	

}
