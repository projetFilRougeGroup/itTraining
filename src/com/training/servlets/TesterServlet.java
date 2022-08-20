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
				Theme st= sf.GetTheme((long) 1);

			//	sf.addTheme("Developpement", 1);
				Theme themedev = new Theme ("Developpement");
				themedev.setSupertheme(st);
				st.getSoustheme().add(themedev);
				System.out.println("4");
				sf.addTheme(themedev);
				
				sf.addTheme("Modelisation", 1);
				sf.addTheme("Java", 2);
				sf.addTheme("Python", 2);
				sf.addTheme("c--", 2);
				sf.addTheme("Basic", 2);
				
				sf.supprimerTheme(7);
				
				Theme th_upd = sf.GetTheme((long) 6);
				th_upd.setNomTheme("C++");
				sf.modifierTheme(th_upd);
				//prereq
				
				sf.addPrerequis("dev", "quizz dev");
				sf.addPrerequis("dev JAVA", "quizz dev JAVA");

				// test find by keyword, show list
				// test find by id
				// test delete
				// test update
				
				//formation
				sf.addFormation("initiation dev java", "0B301", "dev", "dev java", "details formation 0B301",	"ch1, ch2, ch3", 4995, 5);
				sf.addFormation("approfondissement dev java", "0B303", "dev java", "dev java senior", "details formation OB303",	"ch1, ch2, ch3", 9995, 5);

				Formation ob301 = sf.getFormation(3L);
				
				//add prerequis to formation (x)
				Prerequis pr1 = sf.GetPrerequis( 1L);
				ob301.getFormationPrerequis().add(pr1);		
				
				//remove prerequis from formation
			//todo
				
				//add theme to formation
				Theme th1 = sf.GetTheme( 1L);
				ob301.getTheme().add(th1);

				//remove theme from formation
				//todo
						
				
				//modifier formation
				sf.modifierFormation(ob301);
				
				// supprimer formation 
					// doit refuser si sessions rattachées, QUESTION REDA
				
				
				
				//Session
				LocalDate datdeb= LocalDate.now();
				Session sess1 = new Session(datdeb, datdeb, (float) 999.9);
						
						
				//enseignant
					//assignation()
				
				//Salle
				//reservation
				
				//stagiaires
				
				
				//evaluation


		//doGet(request, response);
	}

}
