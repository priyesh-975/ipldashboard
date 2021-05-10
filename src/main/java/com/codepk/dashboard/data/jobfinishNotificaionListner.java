package com.codepk.dashboard.data;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.codepk.dashboard.model.Match;
import com.codepk.dashboard.model.Team;
@Component
public class jobfinishNotificaionListner extends JobExecutionListenerSupport 
{
	
	private static final Logger log = LoggerFactory.getLogger(jobfinishNotificaionListner.class);

	  private final EntityManager em;

	  @Autowired
	  public jobfinishNotificaionListner(EntityManager em)
	  {
	    this.em = em;
	  }
	  @Transactional
	  @Override
	  public void afterJob(JobExecution jobExecution) 
	  {
	    if(jobExecution.getStatus() == BatchStatus.COMPLETED) 
	    {
	      log.info("!!! JOB FINISHED! Time to verify the results");
	      
	      Map<String,Team> teamData= new HashMap<String,Team>();
	      
	      em.createQuery("select m.team1,count(*) from Match m group by m.team1",Object[].class)
	    		  .getResultList()
	    		  .stream()
	    		  .map(e-> new Team((String) e[0],(long) e[1]))
	    		  .forEach(team->teamData.put(team.getTeamName(), team));
	      
	      
			em.createQuery("select m.team2,count(*) from Match m group by m.team2", Object[].class)
		  .getResultList()
		  .stream()
		  .forEach(team->{
			  Team t1=teamData.get((String) team[0]);
			  t1.setTotalMatches(t1.getTotalMatches()+(long)team[1]);
		  });
	      
	      em.createQuery("select m.winner,count(*) from Match m group by m.winner",Object[].class)
		  .getResultList()
		  .stream()
		  .forEach(team->{
			  
			 
			  Team t1=teamData.get((String) team[0]);
			  if(t1 !=null)t1.setTotalWins(t1.getTotalWins()+(long)team[1]);
			  
		  });
	      
	      
	      
	      
	      	teamData.values().forEach(val->em.persist(val));
	      	teamData.values().forEach(val->System.out.println(val));
	     
	    }
	  }

}
