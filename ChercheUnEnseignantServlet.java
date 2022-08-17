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

import com.training.entites.Enseignant;
import com.training.entites.Formation;
import com.training.services.ServiceFormation;

/**
 * Servlet implementation class ChercheUnEnseignantServlet
 */
@WebServlet("/ChercheUnEnseignantServlet")
public class ChercheUnEnseignantServlet extends HttpServlet {
	
	private static Logger logger = Logger.getLogger(ChercheUnEnseignantServlet.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChercheUnEnseignantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyWord = request.getParameter("keyWord");
		logger.info("Recherche d'enseignant par mot clé : " + keyWord); 
		ServiceFormation sf = new ServiceFormation();
		List<Enseignant> result  = sf.rechercheEnseignant(keyWord);
		logger.info("Nombre d'enseignant trouvé: " + result.size());
		request.setAttribute("resultRechercheEnseignant", result);
		
		//	request.setAttribute("workList", workList);
		//	RequestDispatcher rd = request.getRequestDispatcher("resultRecherche.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("enseignant.jsp");
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
