package control;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.google.appengine.api.datastore.EntityNotFoundException;

import sport.Administratie;
import sport.Lid;
import sport.Team;



@SuppressWarnings("serial")
public class SportServlet extends HttpServlet {
	private Administratie admin;
		
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		admin = new Administratie();
		
		//voeg een nieuw lid toe
		if (req.getParameter("knopNieuwLid") != null) {
			this.voegNieuwLidToe(req, resp);
			resp.sendRedirect("/sport");
		}
		//verwijder een lid. Param verwijderLid = definitief
		else if (req.getParameter("verwijderlid") != null || req.getParameter("lidverwijder") != null) {
			this.verwijderLid(req, resp);
		}
		//wijzig lid. Param wijzigLid = definitief
		else if (req.getParameter("wijziglid") != null || req.getParameter("lidwijzig") != null) {
			this.wijzigLid(req, resp);
		}
		//voeg nieuw team toe
		else if (req.getParameter("nieuwteam") != null) {
			this.voegNieuwTeamToe(req, resp);
		}
		//verwijder team Param verwijderteam = definitief
		else if (req.getParameter("teamverwijder") != null || req.getParameter("verwijderteam") != null) {
			this.verwijderTeam(req, resp);
		}
		//wijzig team Param wijzigteam = def
		else if (req.getParameter("teamwijzig") != null || req.getParameter("wijzigteam") != null) {
			this.wijzigTeam(req, resp);
		}
		//geef de teams van een bepaald lid
		else if (req.getParameter("lidteams") != null) {
			this.getTeamsVanLid(req, resp);
		}
		//geef de leden van een team
		else if (req.getParameter("teamleden") != null) {
			this.getLedenVanTeam(req, resp);
		}
		//verwijder een teamspeler
		else if (req.getParameter("verwijderteamspeler") != null) {
			this.verwijderTeamspeler(req, resp);
		}
		//voeg een teamspeler toe
		else if (req.getParameter("voegteamspelertoe") != null) {
			this.voegTeamspelerToe(req, resp);
		}
		
		//ga naar overzichtpagina
		else {
			req.setAttribute("admin", admin);
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/ledenTeams.jsp");
			disp.forward(req, resp);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	/******************************************************************************
	 					hulpmethoden
	 *****************************************************************************/
	
	private void voegNieuwLidToe(HttpServletRequest req, HttpServletResponse resp) throws IOException {
         String roepnaam = req.getParameter("roepnaam");
         String tussenvoegsels = req.getParameter("tussenvoegsels");
         String achternaam = req.getParameter("achternaam");
         String adres = req.getParameter("adres");
         String postcode = req.getParameter("postcode");
         String woonplaats = req.getParameter("woonplaats");
         String telefoon = req.getParameter("telefoon");
         String gebDatum = req.getParameter("gebDatum");
         String geslacht = req.getParameter("geslacht");
         
         Lid lid = new Lid(roepnaam, tussenvoegsels, 
             achternaam, adres, postcode, woonplaats, telefoon, gebDatum, geslacht);
         
         try {
			admin.voegLidToe(lid);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
	}
	
	private void verwijderLid(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String spelerscode = req.getParameter("spelerscode");
		Lid lid = null;
		try {
			lid = admin.getLid(spelerscode);
		} catch (EntityNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//ga naar bevestiging
		if (req.getParameter("lidverwijder") != null) {
			req.setAttribute("lid", lid);
			
			//RequestDispatcher disp = getServletContext().getRequestDispatcher("/verwijderlid.jsp");
			RequestDispatcher disp = req.getRequestDispatcher("/verwijderlid.jsp");
			try {
				disp.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//verwijder lid definitief
		else if (req.getParameter("verwijderlid") != null) {
			ArrayList<Team> teams = null;
			try {
				teams = admin.getSpelerteams(lid);
			} catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Team team: teams) {
				admin.verwijderTeamspeler(team, lid);
			}
			try {
				admin.verwijderLid(lid);
			} catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resp.sendRedirect("/sport");
		}
	}
	
	private void wijzigLid(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		//wijzig lid en ga terug naar overzicht
		if (req.getParameter("wijziglid") != null) {
			Lid lid = null;
			try {
				lid = admin.getLid(req.getParameter("spelerscode"));
			} catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lid.setNr(lid.getNr());
			lid.setRoepnaam(req.getParameter("roepnaam"));
			lid.setTussenvoegsels(req.getParameter("tussenvoegsels"));
			lid.setAchternaam(req.getParameter("achternaam"));
			lid.setAdres(req.getParameter("adres"));
			lid.setPostcode(req.getParameter("postcode"));
			lid.setWoonplaats(req.getParameter("woonplaats"));
			lid.setTelefoon(req.getParameter("telefoon"));
			lid.setGeboortedatum(req.getParameter("geboortedatum"));
			lid.setGeslacht(req.getParameter("geslacht"));
			try {
				admin.wijzigLid(lid);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("/sport");
		}
		//ga naar invoerscherm wijzigLid.jsp
		else {
			Lid lid = null;
			try {
				lid = admin.getLid(req.getParameter("spelerscode"));
			} catch (EntityNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			req.setAttribute("lid", lid);
			RequestDispatcher disp = req.getRequestDispatcher("/wijziglid.jsp");
			try {
				disp.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//verwerk input van invoerLid.jsp
	private void voegNieuwTeamToe(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String teamcode = req.getParameter("teamcode");
		String teamomschrijving = req.getParameter("teamomschrijving");
		
		Team team = new Team(teamcode, teamomschrijving);
		admin.voegTeamToe(team);
		
		resp.sendRedirect("/sport");
	}
	
	//verwijdert een team na bevestiging
	private void verwijderTeam(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Team team = null;
		try {
			team = admin.getTeam(req.getParameter("teamcode"));
		} catch (EntityNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//leid naar verwijderlid.jsp
		if (req.getParameter("teamverwijder") != null) {
			
			req.setAttribute("team", team);
			RequestDispatcher disp = req.getRequestDispatcher("/verwijderteam.jsp");
			try {
				disp.forward(req, resp);
			}
			catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//verwijderLid en terug naar overzicht
		else {
			ArrayList<Lid> teamspelers = null;
			try {
				teamspelers = admin.getTeamspelers(team);
			} catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Lid l: teamspelers) {
				admin.verwijderTeamspeler(team, l);
			}
			try {
				admin.verwijderTeam(team);
			} catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("/sport");
		}
	}
	
	private void wijzigTeam(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Team team = null;
		try {
			team = admin.getTeam(req.getParameter("teamcode"));
		} catch (EntityNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//ga naar wijzigteam.jsp
		if (req.getParameter("teamwijzig") != null) {
			req.setAttribute("team", team);
			RequestDispatcher disp = req.getRequestDispatcher("/wijzigteam.jsp");
			try {
				disp.forward(req, resp);
			}
			catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//wijzig team en ga terug naar overzicht
		else {
			//team.setTeamcode(req.getParameter("teamcode"));
			team.setOmschrijving(req.getParameter("teamomschrijving"));
			admin.wijzigTeam(team);
			resp.sendRedirect("/sport");
		}
	}
	
	//geeft overzicht van teams waar een speler in zit
	private void getTeamsVanLid(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String sc = req.getParameter("spelerscode");
		Lid lid = null;
		try {
			lid = admin.getLid(sc);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Team> teamsLid = null;
		try {
			teamsLid = admin.getSpelerteams(lid);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean isLeeg = false;
		if (teamsLid.isEmpty()) {
			isLeeg = true;
		}
		req.setAttribute("isLeeg", isLeeg);
		req.setAttribute("teams", teamsLid);
		req.setAttribute("lid", lid);
		RequestDispatcher disp = req.getRequestDispatcher("/teamslid.jsp");
		disp.forward(req, resp);
	}
	
	
	//geeft leden van een bepaald team in ledenvanteam.jsp
	private void getLedenVanTeam(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Team team = null;
		try {
			team = admin.getTeam(req.getParameter("teamcode"));
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("team", team);
		
		ArrayList<Lid> teamleden = null;
		try {
			teamleden = admin.getTeamspelers(team);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("teamleden", teamleden);
		
		ArrayList<Lid> leden = admin.getLeden();
		
		req.setAttribute("leden", leden);
		RequestDispatcher disp = req.getRequestDispatcher("/ledenvanteam.jsp");
		disp.forward(req, resp);
	}
	
	//voeg een speler toe aan een team in ledenvanteam.jsp.  Blijf in zelfde scherm
	private void voegTeamspelerToe(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String teamcode = req.getParameter("teamcode");
		String spelerscode = req.getParameter("spelerscode");
		Lid lid = null;
		try {
			lid = admin.getLid(spelerscode);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Team team = null;
		try {
			team = admin.getTeam(teamcode);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		admin.voegTeamspelerToe(team, lid);
		resp.sendRedirect("/sport?teamcode=" + teamcode + "&teamleden=+" );
		
		
	}
	
	//verwijder een speler in een team in ledenvanteam.jsp.  Blijf in zelfde scherm
	private void verwijderTeamspeler(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Lid lid = null;
		try {
			lid = admin.getLid(req.getParameter("spelerscode"));
		} catch (EntityNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Team team = null;
		try {
			team = admin.getTeam(req.getParameter("teamcode"));
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		admin.verwijderTeamspeler(team, lid);
		resp.sendRedirect("/sport?teamcode=" + team.getTeamcode()+ "&teamleden=+" );
	}


}
