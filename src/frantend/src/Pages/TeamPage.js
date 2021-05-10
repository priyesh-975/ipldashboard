
import {React,useEffect,useState} from 'react'
import {useParams} from 'react-router-dom'
import { MatchDetails } from '../component/MatchDetails'
import { ShortMatchDetails } from '../component/ShortMatchDetails'



export const TeamPage =()=> {


    const [team,setTeam]=useState({matches:[]});

    const {teamName}=useParams()

    useEffect(
        
      ()=>{
          const fetchMatches=async()=>{
          const response = await fetch(`http://localhost:8080/team/${teamName}`);
          const data = await response.json();
          setTeam(data);
          console.log(data);
          };
          fetchMatches();
      },[teamName]
    );

    if(!team||!team.teamName)
    {
    return <h1>Team is not found </h1>
    }
  
  return (
    <div className="TeamPage">
    <h1>{team.teamName}</h1>
    <h1>{team.winByWickets}</h1>
    <MatchDetails teamName={team.teamName} match={team.matches[0]}></MatchDetails>
    {team.matches.slice(1).map(match=><ShortMatchDetails   teamName={team.teamName} match={match}/>)}
    <ShortMatchDetails/>
    </div>
  );
}


