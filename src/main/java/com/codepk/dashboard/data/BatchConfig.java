package com.codepk.dashboard.data;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.codepk.dashboard.model.Match;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	final String[] inputDatarows= {"id","season","city","date","team1","team2","toss_winner",
			"toss_decision","result","dl_applied","winner","win_by_runs",
			"win_by_wickets","player_of_match","venue","umpire1","umpire2","umpire3"};
	@Autowired
	  public JobBuilderFactory jobBuilderFactory;

	  @Autowired
	  public StepBuilderFactory stepBuilderFactory;
	  
	  
	  @Bean
	  public FlatFileItemReader<MatchInput> reader()
	  {
		  
	    return new FlatFileItemReaderBuilder<MatchInput>()
	      .name("MatchInputProcess").linesToSkip(1)
	      .resource(new ClassPathResource("matches.csv"))
	      .delimited()
	      .names( inputDatarows)
	      .fieldSetMapper(new BeanWrapperFieldSetMapper<MatchInput>() {{
	        setTargetType(MatchInput.class);
	      }})
	      .build();
	  }
	  
	  @Bean
	  public MatchInputProcess processor() {
	    return new MatchInputProcess();
	  }

	  @Bean
	  public JdbcBatchItemWriter<Match> writer(DataSource dataSource)
	  {
	    return new JdbcBatchItemWriterBuilder<Match>()
	      .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	      .sql("INSERT INTO match(id,season,city,date,team1,team2,toss_winner,toss_Decision,result,winner,win_by_run, win_by_wickets,player_of_thematch,venue,umpire1,umpire2, umpire3 ) "
	      		+ "VALUES(:id,:season,:city,:date,:team1,:team2,:tossWinner,:tossDecision,:result, :winner,:winByRun, :winByWickets,:playerOfThematch,:venue,:umpire1,:umpire2, :umpire3)")
	      .dataSource(dataSource)
	      .build();
	  }
	  @Bean
	  public Job importUserJob(jobfinishNotificaionListner listener, Step step1) {
	    return jobBuilderFactory.get("importUserJob")
	      .incrementer(new RunIdIncrementer())
	      .listener(listener)
	      .flow(step1)
	      .end()
	      .build();
	  }

	  @Bean
	  public Step step1(JdbcBatchItemWriter<Match> writer) {
	    return stepBuilderFactory.get("step1")
	      .<MatchInput, Match> chunk(10)
	      .reader(reader())
	      .processor(processor())
	      .writer(writer)
	      .build();
	  }
	  
	  
}
 




