export const MatchDetails =( { teamName,match})=> {

    if(!match ) return null;

    const secondTeam=match.team1===teamName?match.team2:match.team1;
      const resultMargin= match.winByRun==="0"?match.winByWickets+" wickets": match.winByRun +" runs";
    
  return (
    <div className="MatchDetails">
      <h1>Latest Match</h1>
     <h3> Vs {secondTeam}</h3>
     <h2>{match.date}</h2>
     <h3>at {match.venue}</h3>
     <h3>{match.winner} won by {resultMargin}</h3>
     

    </div>
  );
}