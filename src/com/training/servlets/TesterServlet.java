package com.training.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.type.LocalDateType;

import com.training.entites.Enseignant;
import com.training.entites.Formation;
import com.training.entites.Prerequis;
import com.training.entites.Salle;
import com.training.entites.Session;
import com.training.entites.Stagiaire;
import com.training.entites.Theme;
import com.training.enums.City;
import com.training.services.ServiceFormation;

/**
 * Servlet implementation class TesterServlet
 */
@WebServlet("/TesterServlet")
public class TesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//tests SCRUDS
				ServiceFormation sf = new ServiceFormation();		
				//theme
				//	par script	sf.addTheme("Developpement", 1);
				
				sf.addTheme("Modelisation");
				sf.lierThemes(2L, 1L);

				sf.addTheme("Java", 2);
				sf.addTheme("Python", 2);
				sf.addTheme("c--", 2);
				sf.addTheme("Basic", 2);
				
				// theme maj
				Theme th_upd = sf.GetTheme((long) 5);
				th_upd.setNomTheme("C++");
				sf.modifierTheme(th_upd);
				
				
				//sf.GetThemebyname("suppr").get(0).toString();
				
				// theme suppr, cascade down only (unlink supertheme)
	
				sf.supprimerTheme((long)4L);

				sf.addTheme("to suppr");
				sf.addTheme("to suppr2");
				
				List<Theme> lTh_supp0 = sf.rechercheTheme("to suppr2");
				if (lTh_supp0.size() >0) {
					for (Theme theme : lTh_supp0) {
					sf.addTheme("sub to suppr2", theme.getIdTheme());
					}
				}
				if (lTh_supp0.size() >0) {sf.supprimerTheme(lTh_supp0.get(0).getIdTheme());}
				
				
				List<Theme> lTh_supp = sf.rechercheTheme("suppr");
				if (lTh_supp.size() >0) {
					for (Theme theme : lTh_supp) {
					theme.toString();
					sf.addTheme("subthemeofthemetodelete", lTh_supp.get(0).getIdTheme());
					sf.supprimerTheme(theme);
					}
				}
				long th_supp=7L;
				sf.supprimerTheme(th_supp);

				
				//prereq

	


				sf.addPrerequis("dev JAVA", "quizz dev JAVA");
				sf.addPrerequis("prereq tosuppr ", "no quizz");
				sf.addPrerequis("dev SQL", "quizz dev SQL");
				sf.addPrerequis("prereq tosuppr2 ", "no quizz2");
				sf.addPrerequis("dev SQL avancé", "quizz dev SQL avancé");
				List<Prerequis> recherchetosuppr = sf.recherchePrerequis("suppr");
				if (recherchetosuppr.size() >0 && recherchetosuppr != null) {
					for (Prerequis prereq : recherchetosuppr) {
					sf.supprimerPrerequis(prereq.getIdPrerequis());
					}
				}

				// test find by keyword, show list
				// test find by id
				// test delete
				// test update

				
				
				//formation
				Prerequis prereq = new Prerequis("dev", "quizz dev");
				Formation formation = new Formation("initiation dev java", "0B301", "dev", "dev java", "details formation 0B301",	"ch1, ch2, ch3", 4995, 5);
				formation.getFormationPrerequis().add(prereq);
				

				Theme themedev = new Theme ("Developpement");
//				Theme st= sf.GetTheme((long) 1);
//				themedev.setSupertheme(st);
//				st.getSoustheme().add(themedev);
				System.out.println("4");
				//sf.addTheme(themedev);
				
				formation.getTheme().add(themedev);
				themedev.getFormation().add(formation);
				
				prereq.getPreqs().add(formation);
				System.out.println("add formation OB301 (composite objects) et OB303");
				sf.addFormation(formation);
				Theme st= sf.GetTheme((long) 1);
				sf.lierThemes(themedev.getIdTheme(), st.getIdTheme());
//				themedev.setSupertheme(st);
//				st.getSoustheme().add(themedev);				
//				sf.modifierTheme(themedev);
				
				sf.addFormation("approfondissement dev java", "0B303", "dev java", "dev java senior", "details formation OB303",	"ch1, ch2, ch3", 9995, 5);

				//Formation ob303 = sf.rechercheFormation("approfondissement").get(0);
				Formation ob303 = sf.getFormation((long) 1L);

				ob303.toString();
				
				//add prerequis to formation (x)
				Prerequis pr1 = sf.GetPrerequis( 1L);
				ob303.getFormationPrerequis().add(pr1);		
				
				//remove prerequis from formation
			//todo
				
				//add theme to formation
				Theme th1 = sf.GetTheme( 1L);
				ob303.getTheme().add(th1);

				//remove theme from formation
				//todo
						
				
				//modifier formation
				sf.modifierFormation(ob303);
				
				// supprimer formation 
					// doit refuser si sessions rattachées, QUESTION REDA
				
				
				
				//Session
				LocalDate datdeb= LocalDate.now();
				Session sess1 = new Session( datdeb, datdeb, (float) 999.9);
				LocalDate datdeb2= LocalDate.of(2023, 10, 20);
				Session sess2 = new Session( datdeb2, datdeb2, (float) 999.9);
				
				
				sf.addSession(sess1);
				sf.addSession(sess2);
				
				sess1.setFormation(ob303);
				sess1.setNb_max(10);
				sf.modifierSession(sess1);
				

				sess2.setNb_max(14);
				sess2.setDateFinSession(LocalDate.of(2023, 10, 25));
				sf.modifierSession(sess2);
				
				sess2.setFormation(ob303);
	
				System.out.println("link session-formation");
				sf.setSessionFormation(sess2.getId(),ob303.getIdFormation());
				
				
				
				//enseignant
					//assignation()
				
				sf.addEnseignant("bendraou", "reda", "reda.ben@gmail.com", "0607080910", "la ou il habite");
				Enseignant ens2 = new Enseignant ("hellart","jacques", "emailjacque", "teljacques", "adresse jacques");
				sf.addEnseignant(ens2);
				
//				sess1.setEnseignant(ens2);
//				ens2.getSessions().add(sess1);
//				sf.modifierEnseignant(ens2);
				
				long idEnseignant=1;
				long idSession=1;
				boolean assignationsucces = sf.assignerEnseignant(idEnseignant, idSession);
				System.out.println("assignation succes: " + assignationsucces);
				sf.assignerEnseignant(ens2.getIdEnseignant(), sess1.getId());
				
				
				long idFormation=2;
				sf.certifierEnseignant(idEnseignant, idFormation); // stub

				
				//stagiaires
				sf.addStagiaire("boucheron", "pierre", "email.p@email.b", "0610111213", "adresse pierre");
				Stagiaire stag2= new Stagiaire("Maher", "Amri", "email.M@email.A", "+3309080706", "adresse maher");
				sf.addStagiaire(stag2);
				
				long idStag1 = 1;
				Stagiaire stagToIncrire = sf.getStagiaire(idStag1);
				Session sessioninscription = sf.getSession(idSession);
				sf.inscrireStagiaire(stagToIncrire.getId(), sessioninscription.getId() );
	

				List<Stagiaire> lstagToIncrire2 = sf.rechercheStagiaire("maher");
				if (lstagToIncrire2 != null || lstagToIncrire2.size() >0) {
					Stagiaire stagToIncrire2= lstagToIncrire2.get(0);
					Session sessioninscription2 = sf.getSession(3L);
//					Stagiaire stagToIncrire2 = sf.rechercheStagiaire("maher").get(0);
//					Session sessioninscription2 = sf.rechercheSession("+").get(0);
					
					sf.inscrireStagiaire(stagToIncrire2.getId(), sessioninscription2.getId() );
					
					sf.inscrireStagiaire(stagToIncrire2.getId(), 1L);
					sf.deinscrireStagiaire(stagToIncrire2.getId(), 1L);
				}

				
				// evaluation

				
				//Salle
				
				
				
				

				Salle salle1 = new Salle("10.15", "adresse centre", "email centre", 20, City.Bordeaux, false, true);
				
				sf.addSalle(salle1);
				sf.addSalle("4.02", "adresse centre", "email centre", 16, City.Paris, true, true);
				
				Salle sallemod = sf.getSalle(1L);
				sallemod.setCity(City.Paris);
				sf.modifierSalle(sallemod);
				
				sf.addSalle("tosuppr", "adresse centre", "email centre", 999, City.Paris, true, true);
				Salle sallesuppr = sf.rechercheSalle("tosuppr").get(0);
				sf.supprimerSalle(sallesuppr);
				
				//reservation
				
				//reserv salle S pour session sess au jour j
				
				//reserv salle S pour session sess (du jour début a jour fin (d'apres durée formation))
				
				// echec de réservation si salle 
				
				//trouve salle dispo pour session (dispo de session.jourdeb a session.jourdeb+formation.duree (en jours ouvrés)
				// avec caractéristiques requises par formation&session (équipement informatique, places (pour session.evaluations.size si pas précisé)
				// etc...
				
				
				//evaluation


		//doGet(request, response);
	}

}
