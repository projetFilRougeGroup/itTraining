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

import com.training.entites.Formation;
import com.training.services.ServiceFormation;

/**
 * Servlet implementation class AfficherToutLesFormationsServlet
 */
@WebServlet("/AfficherToutLesFormationsServlet")
public class AfficherToutLesFormationsServlet extends HttpServlet {
	
	private static Logger logger = Logger.getLogger(AfficherToutLesFormationsServlet.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherToutLesFormationsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//String keyWord = request.getParameter("keyWord");
		//logger.info("Recherche de formation par mot clé : " + keyWord); 
		ServiceFormation sf = new ServiceFormation();
		List<Formation> result  = sf.afficherToutLesFormations();
		logger.info("Nombre de formation trouvé: " + result.size());
		request.setAttribute("resultRechercheFormation", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("afficherLesFormations.jsp");
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
