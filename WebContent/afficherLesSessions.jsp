<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List, java.text.*" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/index.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="css/rechercheFormation.css">
<link rel="stylesheet" type="text/css" href="css/tableaux.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<title>Afficher et gérer les Sessions</title>
</head>
<body>

	<form action="AfficherToutesLesSessionsServlet" method="GET">
		
			
				    <label for="affich">
				   Afficher vos sessions!
				    </label>
				    <input type="submit" value="Afficher !"/>
	</form>
	<br />
	<c:forEach var="workload" items="${resultRechercheSession}">
	
				<table>
		            <tr> 
		            
		            	<td>id Session</td>
		                <td>Date Début Session</td>
						<td>Date Fin Session</td>
		                <td>Prix</td>
		                
		                <td>IdFormation</td>
		                <td>IdEnseignant</td>
		                <td>liste Stagiaires inscrits</td>
		                <td>liste Salles réservées</td>
		             
		            </tr>
		            <tr>
			            <td>${workload.idSession}</td>
			            <td>${workload.dateDebutSession}</td>
			            <td>${workload.dateFinSession}</td>
						<td>${workload.priceSession}</td>	           
						
			            <td>${workload.IdFormation}</td>
			            <td>${workload.IdEnseignant}</td>
						
			            <td>${workload.listeStagiairesInscrits}</td>
			            <td>${workload.listeSallesReservees}</td>
			           
			            <td>
			            
			            <form action="ModifierUneSessionServlet" method="POST">
			            		
			            		
			            		<button type="submit">
			            		<img src="images/editing.png" style="width: 35px; cursor:pointer" alt="modifier !" title="Modifier !"/>
			            		</button>
			            		
			            	</form>
			            
			            	<form action="SupprimerUneSessionServlet" method="POST">
			            		
			            	 <button type="submit">
			            		<img src="images/delete.png" style="width: 35px; cursor:pointer" alt="Supprimer !" title="Supprimer !"/>
			            		</button>
			            		
			            	</form>
			            	
			            
			            </td>
		            </tr>
	            </table>
	</c:forEach>


<c:url var="thisURL" value="index.html">
</c:url>
<a href="<c:out value="${thisURL}"/>">Retour à l'accueil</a>


</body>
</html>