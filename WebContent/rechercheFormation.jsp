<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.text.*" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="css/rechercheFormation.css">
<link rel="stylesheet" type="text/css" href="css/tableaux.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

<title>Recherche / Affichage d'une formation</title>
</head>

<body>

<h1>La recherche d'une formation !</h1>

	<form action="ChercheUneFormationServlet" method="POST">
		
				    <label for="rech">
				    Trouver une formation à distance ou en présentiel !
				    </label>
				    <input id="rech" name="keyWord" type="text" placeholder="Thème, réfèrence, mot clé .."/>
				    <input type="submit" value="Chercher !"/>
	</form>
	
<div>
	<h3>Nombre de formation trouvé: ${fn:length(resultRechercheFormation)}</h3>
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
			        </tr>
	            </table>
	</c:forEach>
</div>
</body>
</html>