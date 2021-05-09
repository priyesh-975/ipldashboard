package com.codepk.dashboard.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Match {
	
	@Id
	private long id;
	private String season;
	private String city;
	private LocalDate date;
	private String team1;	
	private String team2;	
	private String tossWinner;
	private String tossDecision;
	private String result;	
	private String winner	;
	private String winByRun;
	private String winByWickets;
	private String playerOfThematch	;
	private String venue;	
	private String umpire1;	
	private String umpire2;	
	private String umpire3;
	
	public Match(){
		
	}
	@Override
	public String toString() {
		return "Match [id=" + id + ", season=" + season + ", city=" + city + ", date=" + date + ", team1=" + team1
				+ ", team2=" + team2 + ", tossWinner=" + tossWinner + ", tossDecision=" + tossDecision + ", result="
				+ result + ", winner=" + winner + ", winByRun=" + winByRun + ", winByWickets=" + winByWickets
				+ ", playerOfThematch=" + playerOfThematch + ", venue=" + venue + ", umpire1=" + umpire1 + ", umpire2="
				+ umpire2 + ", umpire3=" + umpire3 + "]";
	}
	public Match(long id, String season, String city, LocalDate date, String team1, String team2, String tossWinner,
			String tossDecision, String result, String winner, String winByRun, String winByWickets,
			String playerOfThematch, String venue, String umpire1, String umpire2, String umpire3) {
		super();
		this.id = id;
		this.season = season;
		this.city = city;
		this.date = date;
		this.team1 = team1;
		this.team2 = team2;
		this.tossWinner = tossWinner;
		this.tossDecision = tossDecision;
		this.result = result;
		this.winner = winner;
		this.winByRun = winByRun;
		this.winByWickets = winByWickets;
		this.playerOfThematch = playerOfThematch;
		this.venue = venue;
		this.umpire1 = umpire1;
		this.umpire2 = umpire2;
		this.umpire3 = umpire3;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getTossWinner() {
		return tossWinner;
	}
	public void setTossWinner(String tossWinner) {
		this.tossWinner = tossWinner;
	}
	public String getTossDecision() {
		return tossDecision;
	}
	public void setTossDecision(String tossDecision) {
		this.tossDecision = tossDecision;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getWinByRun() {
		return winByRun;
	}
	public void setWinByRun(String winByRun) {
		this.winByRun = winByRun;
	}
	public String getWinByWickets() {
		return winByWickets;
	}
	public void setWinByWickets(String winByWickets) {
		this.winByWickets = winByWickets;
	}
	public String getPlayerOfThematch() {
		return playerOfThematch;
	}
	public void setPlayerOfThematch(String playerOfThematch) {
		this.playerOfThematch = playerOfThematch;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getUmpire1() {
		return umpire1;
	}
	public void setUmpire1(String umpire1) {
		this.umpire1 = umpire1;
	}
	public String getUmpire2() {
		return umpire2;
	}
	public void setUmpire2(String umpire2) {
		this.umpire2 = umpire2;
	}
	public String getUmpire3() {
		return umpire3;
	}
	public void setUmpire3(String umpire3) {
		this.umpire3 = umpire3;
	}
	      
	     
           
}          
         
         
          
         
         
         
         
         
         	
         
         
         
         
                                  