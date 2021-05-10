import {Link} from 'react-router-dom'

export const ShortMatchDetails =({teamName,match})=> {

  if(!match ) return null;

  const secondTeam=match.team1===teamName?match.team2:match.team1;  
    const resultMargin= match.winByRun==="0"?match.winByWickets+" wickets": match.winByRun +" runs";
    const secondTeamLink=`/teams/${secondTeam}`

  return (
    <div className="ShortMatchDetails">
      <h3>Vs
        <Link to={secondTeamLink}>{secondTeam}</Link> </h3>
      <p> {match.winner} won by {resultMargin}</p> 
    </div>
  );
}