package com.codepk.dashboard.data;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import com.codepk.dashboard.model.Match;

public class MatchInputProcess implements ItemProcessor<MatchInput, Match>{
	

	  private static final Logger log = LoggerFactory.getLogger(MatchInputProcess.class);

	  @Override
	  public Match process(final MatchInput matchinput) throws Exception {
		  
		  Match match = new Match();
		  
		  match.setId(Long.parseLong(matchinput.getId()));
		  match.setSeason(matchinput.getSeason());
		  match.setCity(matchinput.getCity());
		  match.setDate(LocalDate.parse(matchinput.getDate()));
		  String  firstIningsteam="";
		  String  sencondIningsteam="";
		  
		  if(matchinput.getToss_decision().equalsIgnoreCase("bat")){
			  firstIningsteam=matchinput.getToss_winner();
			  sencondIningsteam=(matchinput.getToss_winner()).equalsIgnoreCase(matchinput.getTeam2()) ? matchinput.getTeam2():matchinput.getTeam1();	
			  }
		  else
		  {
			  sencondIningsteam=matchinput.getToss_winner();
			  firstIningsteam=(matchinput.getToss_winner()).equalsIgnoreCase(matchinput.getTeam1()) ? matchinput.getTeam1():matchinput.getTeam2();
		  }
		  match.setTeam1(firstIningsteam);
		  match.setTeam2(sencondIningsteam);
		  match.setTossWinner(matchinput.getToss_winner());
		  match.setTossDecision(matchinput.getToss_decision());
		  match.setResult(matchinput.getResult());
		  match.setWinByRun(matchinput.getWin_by_runs());
		  match.setWinByWickets(matchinput.getWin_by_wickets());
		  match.setWinner(matchinput.getWinner());
		  match.setPlayerOfThematch(matchinput.getPlayer_of_match());
		  match.setVenue(matchinput.getVenue());
		  match.setUmpire1(matchinput.getUmpire1());
		  match.setUmpire2(matchinput.getUmpire2());
		  match.setUmpire3(matchinput.getUmpire3());
		  
		  
		  
		return match;
	   

	}

}
