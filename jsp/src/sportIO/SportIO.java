package sportIO;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import sport.Lid;
import sport.Team;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterPredicate;


public class SportIO {
	private DatastoreService datastore;
	
	public SportIO() {
		datastore = DatastoreServiceFactory.getDatastoreService();
	}
	
	public void voegLidToe(Lid lid) throws ParseException {
		Entity e = new Entity("Lid", lid.getSpelerscode());
		e.setProperty("spelerscode", lid.getSpelerscode());
		e.setProperty("lidnr", lid.getNr());
		e.setProperty("roepnaam", lid.getRoepnaam());
		e.setProperty("tussenvoegsels", lid.getTussenvoegsels());
		e.setProperty("achternaam", lid.getAchternaam());
		e.setProperty("adres", lid.getAdres());
		e.setProperty("postcode", lid.getPostcode());
		e.setProperty("woonplaats", lid.getWoonplaats());
		e.setProperty("telefoon", lid.getTelefoon());
		e.setProperty("geslacht", lid.getGeslacht());
		Date gebDatum = null;
		gebDatum = new SimpleDateFormat("yyyy-MM-dd").parse(lid.getGeboortedatum());
		e.setProperty("geboortedatum", gebDatum);
		
		datastore.put(e);
	}
	
	public void verwijderLid(Lid lid){
		Key lidKey = KeyFactory.createKey("Lid", lid.getSpelerscode());
		datastore.delete(lidKey);
	}
	
	// wijzigen in datastore == toevoegen
	public void wijzigLid(Lid lid) throws ParseException {
		voegLidToe(lid);
	}
	
	public Lid getLid(String spelerscode) throws EntityNotFoundException {
		Lid lid = new Lid();
		Key k = KeyFactory.createKey("Lid", spelerscode);
		Entity res;

		res = datastore.get(k);
		
		lid.setSpelerscode((String)res.getProperty("spelerscode"));
		long l = (long) res.getProperty("lidnr"); //int wordt opgeslagen als long in datastore :-/
		int lidnummer = (int) l;
		lid.setNr(lidnummer);
		String roepnaam = (String) res.getProperty("roepnaam");
		String tussenvoegsels = (String) res.getProperty("tussenvoegsels");
		String achternaam = (String) res.getProperty("achternaam");
		lid.setRoepnaam(roepnaam);
		lid.setTussenvoegsels(tussenvoegsels);
		lid.setAchternaam(achternaam);
		if (tussenvoegsels.equals("")) {
			lid.setNaam(roepnaam + " " + achternaam);
		}
		else {
			lid.setNaam(roepnaam + " " + tussenvoegsels + " " + achternaam);
		}
		
		lid.setAdres((String) res.getProperty("adres"));
		lid.setPostcode((String) res.getProperty("postcode"));
		lid.setWoonplaats((String) res.getProperty("woonplaats"));
		lid.setTelefoon((String) res.getProperty("telefoon"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date gd = (Date) res.getProperty("geboortedatum");
		lid.setGeboortedatum(sdf.format(gd));
		lid.setGeslacht((String) res.getProperty("geslacht"));
		
		
		return lid;
	}
	
	public ArrayList<Lid> getLedenLijst() {
		ArrayList<Lid> leden = new ArrayList<Lid>();
		Query q = new Query("Lid").addSort("lidnr", SortDirection.ASCENDING);
		PreparedQuery pq = datastore.prepare(q);
		
		for (Entity result: pq.asIterable()) {
			Lid lid = new Lid();
			long sn = (long) result.getProperty("lidnr");
			int spelersnr = (int) sn;
			lid.setNr(spelersnr);
			String spelerscode = (String) result.getProperty("spelerscode");
			lid.setSpelerscode(spelerscode);
			String roepnaam = (String) result.getProperty("roepnaam");
			lid.setRoepnaam(roepnaam);
			String tussenvoegsels = (String) result.getProperty("tussenvoegsels");
			lid.setTussenvoegsels(tussenvoegsels);
			String achternaam = (String) result.getProperty("achternaam");
			lid.setAchternaam(achternaam);
			String naam = "";
			if (tussenvoegsels.equals("") ) {
				naam = roepnaam + " " + achternaam;
			}
			else {
				naam = roepnaam + " " + tussenvoegsels + " " + achternaam;
			}
			lid.setNaam(naam);
			
			String adres = (String) result.getProperty("adres");
			lid.setAdres(adres);
			String postcode = (String) result.getProperty("postcode");
			lid.setPostcode(postcode);
			String woonplaats = (String) result.getProperty("woonplaats");
			lid.setWoonplaats(woonplaats);
			String telefoon = (String) result.getProperty("telefoon");
			lid.setTelefoon(telefoon);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date gebDatum = (Date) result.getProperty("geboortedatum");
			String geboortedatum = sdf.format(gebDatum);
			lid.setGeboortedatum(geboortedatum);
			String geslacht = (String) result.getProperty("geslacht");
			lid.setGeslacht(geslacht);
			
			leden.add(lid);
		}
		return leden;
	}
	
	public void voegTeamToe(Team team) {
		Entity ent = new Entity("Team", team.getTeamcode());
		ent.setProperty("teamcode", team.getTeamcode());
		ent.setProperty("teamomschrijving", team.getOmschrijving());
		datastore.put(ent);
	}
	
	public void setTeamspeler(Team team, Lid lid) {
		Entity e = new Entity("Teamspeler", team.getTeamcode() + lid.getSpelerscode());
		e.setProperty("teamcode", team.getTeamcode());
		e.setProperty("spelerscode", lid.getSpelerscode());
		datastore.put(e);
	}
	
	public void verwijderTeamspeler(Team team, Lid lid) {
		Key k = KeyFactory.createKey("Teamspeler", team.getTeamcode() + lid.getSpelerscode());
		datastore.delete(k);
	}
	
	public ArrayList<Lid> getTeamspelers(Team team) throws EntityNotFoundException {
		ArrayList<Lid> teamleden = new ArrayList<Lid>();
		Filter teamcode =  new FilterPredicate("teamcode", FilterOperator.EQUAL, team.getTeamcode());
		Query q = new Query("Teamspeler").setFilter(teamcode);
		PreparedQuery pq = datastore.prepare(q);
		
		for (Entity result: pq.asIterable()) {
				Lid lid = this.getLid( (String) result.getProperty("spelerscode"));
				teamleden.add(lid);
		}
		return teamleden;
	}
	
	public ArrayList<Team> getSpelerteams( Lid lid) throws EntityNotFoundException{
		ArrayList<Team> spelerteams = new ArrayList<Team>();
		Filter spelerscode =  new FilterPredicate("spelerscode", FilterOperator.EQUAL, lid.getSpelerscode());
		Query q = new Query("Teamspeler").setFilter(spelerscode);
		PreparedQuery pq = datastore.prepare(q);
		for (Entity result: pq.asIterable()) {
				Team team = this.getTeam( (String) result.getProperty("teamcode"));
				spelerteams.add(team);
		}
		return spelerteams;
	}

	public void verwijderTeam(Team team) {
		Key teamKey = KeyFactory.createKey("Team", team.getTeamcode());
		datastore.delete(teamKey);
	}
	
	public void wijzigTeam(Team team) {
		voegTeamToe(team);
	}
	
	public Team getTeam(String teamcode) throws EntityNotFoundException {
		Team team = new Team();
		Key k = KeyFactory.createKey("Team", teamcode);
		Entity res;
		res = datastore.get(k);
			team.setTeamcode((String) res.getProperty("teamcode"));
			team.setOmschrijving((String) res.getProperty("teamomschrijving"));
		return team;
	}
	
	public ArrayList<Team> getTeamLijst() {
		ArrayList<Team> teams = new ArrayList<Team>();
		Query q = new Query("Team").addSort("teamcode", SortDirection.ASCENDING);
		PreparedQuery pq = datastore.prepare(q);
		
		for (Entity result: pq.asIterable()) {
			Team team = new Team();
			String tc = (String) result.getProperty("teamcode");
			team.setTeamcode(tc);
			String to = (String) result.getProperty("teamomschrijving");
			team.setOmschrijving(to);
			teams.add(team);
		}
		return teams;
	}
}
