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
<title>Afficher tout les formations</title>
</head>
<body>




	<form action="AfficherToutLesFormationsServlet" method="POST">
		
			
				    <label for="affich">
				   Afficher tout les formations à distance ou en présentiel !
				    </label>
				    <input type="submit" value="Afficher !"/>
	</form>
	<br />
	<c:forEach var="workload" items="${resultRechercheFormation}">
	
				<table>
		            <tr> 
		            
		            	<td>id Formation</td>
		                <td >Nom Formation</td>
		                <td>Référence</td>
		                
		                <td >Public</td>
		                <td>Objectifs</td>
		                <td >Détails</td>
		                <td>Chapters</td>
		                <td >Prix</td>
		                <td >Durée</td>
		                
		                <td>Action</td>
		             
		            </tr>
		            <tr>
			            <td>${workload.idFormation}</td>
			            <td>${workload.nomFormation}</td>
			            <td>${workload.referenceFormation}</td>
			           
			            <td>${workload.publicFormation}</td>
			            <td>${workload.objectifsFormation}</td>
			            <td>${workload.detailsFormation}</td>
			            <td>${workload.chaptersFormation}</td>
			            <td>${workload.priceFormation}</td>
			            <td>${workload.dureeFormation}</td>
			           
			            <td>
			            
			            <form action="ModifierUneFormationServlet" method="POST">
			            		
			            		
			            		<button type="submit">
			            		<img src="images/editing.png" style="width: 35px; cursor:pointer" alt="modifier !" title="Modifier !"/>
			            		</button>
			            		
			            	</form>
			            
			            	<form action="SupprimerUneFormationServlet" method="POST">
			            		
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