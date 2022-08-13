package com.training.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entites.Session;
import com.training.services.ServiceFormation;

import org.jboss.logging.Logger;

/**
 * Servlet implementation class AfficherToutesLesSessions
 */
@WebServlet("/AfficherToutesLesSessions")
public class AfficherToutesLesSessionsServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(AfficherToutesLesSessionsServlet.class);
	
	private static final long serialVersionUID = 1L;
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherToutesLesSessionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServiceFormation sf = new ServiceFormation();
		List<Session> result  = sf.AfficherLesSessions();
		logger.info("Nombre de Session trouvées: " + result.size());
		request.setAttribute("resultRechercheSession", result);
		//response.getWriter().append("Served at: ").append(request.getContextPath());		
		RequestDispatcher rd = request.getRequestDispatcher("afficherLesSessions.jsp");
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
