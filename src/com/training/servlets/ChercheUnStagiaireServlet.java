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

import com.training.entites.Stagiaire;
import com.training.services.ServiceFormation;

/**
 * Servlet implementation class ChercheUnStagiaireServlet
 */
@WebServlet("/ChercheUnStagiaireServlet")
public class ChercheUnStagiaireServlet extends HttpServlet {
	
	private static Logger logger = Logger.getLogger(ChercheUneFormationServlet.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChercheUnStagiaireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyWord = request.getParameter("keyWord");
		logger.info("Recherche de stagiaire par mot clé : " + keyWord); 
		ServiceFormation sf = new ServiceFormation();
		List<Stagiaire> result  = sf.rechercheStagiaire(keyWord);
		logger.info("Nombre de stagiaire trouvé: " + result.size());
		request.setAttribute("resultRechercheStagiaire", result);
		
		//	request.setAttribute("workList", workList);
		//	RequestDispatcher rd = request.getRequestDispatcher("resultRecherche.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("stagiaire.jsp");
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
