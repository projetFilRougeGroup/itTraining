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

import com.fasterxml.classmate.util.ResolvedTypeCache.Key;
import com.training.entites.Formation;
import com.training.entites.Session;
import com.training.services.ServiceFormation;

/**
 * Servlet implementation class ChercheUneFormationServlet
 */
@WebServlet("/ChercheUneFormationServlet")
public class ChercheUneFormationServlet extends HttpServlet {
	
	private static Logger logger = Logger.getLogger(ChercheUneFormationServlet.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChercheUneFormationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyWord = request.getParameter("keyWord");
		logger.info("Recherche de formation par mot clé : " + keyWord); 
		ServiceFormation sf = new ServiceFormation();
		List<Formation> result  = sf.rechercheFormation(keyWord);
		logger.info("Nombre de formation trouvé: " + result.size());
		request.setAttribute("resultRechercheFormation", result);
		
		//	request.setAttribute("workList", workList);
		//	RequestDispatcher rd = request.getRequestDispatcher("resultRecherche.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("rechercheFormation.jsp");
		rd.forward(request, response);
		
		//	response.sendRedirect("resultRecherche.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
