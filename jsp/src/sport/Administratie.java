package sport;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import com.google.appengine.api.datastore.EntityNotFoundException;

import sportIO.SportIO;

public class Administratie implements Serializable {
	private SportIO io;
	private ArrayList<Lid> leden;
	private ArrayList<Team> teams;
	private boolean ledenIsLeeg;
	private boolean teamsIsLeeg;
	
	public Administratie() {
		io = new SportIO();
		leden = io.getLedenLijst();
		if (leden.isEmpty())
			ledenIsLeeg = true;
		teams = io.getTeamLijst();
		if (teams.isEmpty())
			teamsIsLeeg = true;
	}
	

	public boolean isLedenIsLeeg() {
		return ledenIsLeeg;
	}


	public void setLedenIsLeeg(boolean ledenIsLeeg) {
		this.ledenIsLeeg = ledenIsLeeg;
	}


	public boolean isTeamsIsLeeg() {
		return teamsIsLeeg;
	}


	public void setTeamsIsLeeg(boolean teamsIsLeeg) {
		this.teamsIsLeeg = teamsIsLeeg;
	}


	public ArrayList<Lid> getLeden() {
		return leden;
	}
	
	public ArrayList<Team> getTeams() {
		return teams;
	}
	
	public SportIO getIo() {
		return io;
	}


	public void setIo(SportIO io) {
		this.io = io;
	}


	public void setLeden(ArrayList<Lid> leden) {
		this.leden = leden;
	}


	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

	
	public void voegLidToe(Lid lid) throws ParseException {
		if (leden.isEmpty()) {
			lid.setNr(1);
		}
		else {
			int nr = leden.get(leden.size() - 1).getNr() + 1;
			lid.setNr(nr);
		}
		
		io.voegLidToe(lid);
	}
	
	public Lid getLid(String spelerscode) throws EntityNotFoundException {
		Lid lid = io.getLid(spelerscode);
		return lid;
	}
	
	public void verwijderLid(Lid lid) throws EntityNotFoundException {
		ArrayList<Team> teams = io.getSpelerteams(lid);
		for (Team team : teams) {
			io.verwijderTeamspeler(team, lid);
		}
		io.verwijderLid(lid);
	}
	
	public void wijzigLid(Lid lid) throws ParseException {
		io.wijzigLid(lid);
	}
	
	public void voegTeamToe(Team team) {
		io.voegTeamToe(team);
	}
	
	public void verwijderTeam(Team team) throws EntityNotFoundException {
		ArrayList<Lid> teamspelers = io.getTeamspelers(team);
		for (Lid lid : teamspelers) {
			io.verwijderTeamspeler(team, lid);
		}
		io.verwijderTeam(team);
	}
	
	public void wijzigTeam(Team team) {
		io.wijzigTeam(team);
	}
	
	public Team getTeam(String teamcode) throws EntityNotFoundException {
		Team team = io.getTeam(teamcode);
		return team;
	}
	
	public ArrayList<Lid> getTeamspelers(Team team) throws EntityNotFoundException {
		ArrayList<Lid> teamspelers = io.getTeamspelers(team);
		return teamspelers;
	}
	
	public ArrayList<Team> getSpelerteams(Lid lid) throws EntityNotFoundException {
		ArrayList<Team> spelerteams = io.getSpelerteams(lid);

		return spelerteams;
	}
	
	public void verwijderTeamspeler(Team team, Lid lid) {
		io.verwijderTeamspeler(team, lid);
	}
	
	public void voegTeamspelerToe(Team team, Lid lid) {
		io.setTeamspeler(team, lid);
	}

}
