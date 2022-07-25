package com.training.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;


import com.training.entites.Prerequis;
import com.training.services.ServiceFormation;

/**
 * Servlet implementation class AfficherToutLesPrerequisServlet
 */
@WebServlet("/AfficherToutLesPrerequisServlet")
public class AfficherToutLesPrerequisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(AfficherToutLesFormationsServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherToutLesPrerequisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceFormation sf = new ServiceFormation();
		List<Prerequis> result  = sf.afficherToutLesPrerequis();
		logger.info("Nombre de prérequis trouvé: " + result.size());
		request.setAttribute("resultRecherchePrerequis", result);
		
		logger.info(result);
		RequestDispatcher rd = request.getRequestDispatcher("prerequis.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
