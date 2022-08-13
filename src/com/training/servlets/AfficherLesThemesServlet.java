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

import com.training.entites.Theme;
import com.training.services.ServiceFormation;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AfficherLesThemesServlet
 */
@WebServlet("/AfficherLesThemesServlet")
public class AfficherLesThemesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(AfficherLesThemesServlet.class);
	

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherLesThemesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//String keyWord = request.getParameter("keyWord");
		//logger.info("Recherche de formation par mot clé : " + keyWord); 
		ServiceFormation sf = new ServiceFormation();
		List<Theme> result  = sf.afficherTousLesThemes();
		logger.info("Themes trouvés: " + result.size());
//		logger.info("Themes trouvés: " + result.get toString());=> LazyInitializationException: failed to lazily initialize a collection of role: com.training.entites.Theme.formation, 
		request.setAttribute("resultRechercheThemes", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("afficherLesThemes.jsp");
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
