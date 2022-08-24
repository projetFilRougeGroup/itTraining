package com.training.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.type.LocalDateType;

import com.training.entites.Enseignant;
import com.training.entites.Formation;
import com.training.entites.Prerequis;
import com.training.entites.Session;
import com.training.entites.Theme;
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
				
				sf.supprimerTheme(4);
				
				Theme th_upd = sf.GetTheme((long) 6);
				th_upd.setNomTheme("C++");
				sf.modifierTheme(th_upd);
				//prereq
				


				sf.addPrerequis("dev JAVA", "quizz dev JAVA");

				// test find by keyword, show list
				// test find by id
				// test delete
				// test update
				
				//formation
				Prerequis prereq = new Prerequis("dev", "quizz dev");
				//sf.addPrerequis(prereq);
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
				themedev.setSupertheme(st);
				st.getSoustheme().add(themedev);				
				sf.modifierTheme(themedev);
				
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
				sf.addSession(sess1);		
						
				//enseignant
					//assignation()
				
				sf.addEnseignant("bendraou", "reda", "reda.ben@gmail.com", "0607080910", "la ou il habite");
				Enseignant ens2 = new Enseignant ("hellart","jacques", "emailjacque", "teljacques", "adresse jacques");
				sf.addEnseignant(ens2);
				
				sess1.setEnseignant(ens2);
				ens2.getSessions().add(sess1);
				sf.modifierEnseignant(ens2);
				
				//Salle
				//reservation
				
				//stagiaires
				
				
				//evaluation


		//doGet(request, response);
	}

}
