package com.training.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.training.entites.Formation;
import com.training.services.ServiceFormation;



/**
 * Servlet implementation class AjouterUneSessionServlet
 */
@WebServlet("/AjouterUneSessionServlet")
public class AjouterUneSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
	private static Logger logger = Logger.getLogger(AjouterUneSessionServlet.class);         
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterUneSessionServlet() {
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
		boolean failure=false;
		String messagefailure= "";
		// necessaire
		Long id = Long.parseLong(request.getParameter("ID_Formation"));

		//optionnels
		LocalDate dateDebut = null;
		LocalDate dateFin = null;
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// LocalDate format = yyyy-MM-dd
		
		// example : String dateInString = "7-Jun-2013";
		try {
				dateDebut = LocalDate.parse(request.getParameter("dateDebut"),formatter);
			} catch (Exception e) {
				messagefailure +="date début incompatible dd/MM/yyyy ";
			failure=true;
			};

		try {
				dateFin = LocalDate.parse(request.getParameter("dateFin"),formatter);
		} catch (Exception e) {
			messagefailure +="date fin incompatible dd/MM/yyyy ";
			failure=true;
		};		
		float prixsession =Float.parseFloat(request.getParameter("prixsession"));

		logger.info("test pre recherche formation.");
		ServiceFormation SF = new ServiceFormation();
		logger.info("test pre recherche formationstep2.");
		boolean formationexiste= SF.CheckFormation(id);
		if (!formationexiste) {
			failure=true;
			messagefailure +="Pas de formation trouvée";
		}
		
		
		if (failure) {
			logger.error(messagefailure);
		} else {
			logger.info("formation valide. proceed with session creation");
			SF.addSession( id,  dateDebut,  dateFin,  prixsession);
			}	
		response.sendRedirect("ajouterUneSession.jsp");
		}
	}


