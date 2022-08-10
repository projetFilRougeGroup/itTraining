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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<title>Salle !</title>
</head>
<body>

<h1>Partie Salle CRUD !</h1>
<c:url var="thisURL" value="index.html">
</c:url>
<a href="<c:out value="${thisURL}"/>">Retour à l'accueil</a>

	<form action="ChercheUneSalleServlet" method="POST">
		
			
				    <label for="rech">
				    Recherche une salle !
				    </label>
				    <input id="rech" name="keyWord" type="text" placeholder="Mots clé .."/>
				    <input type="submit" value="Chercher !"/>
	</form>
	
	<br />
	<c:forEach var="workload" items="${resultRechercheSalle}">
	
				<table>
		            <tr> 		            
		            	<td>id Salle</td>
		                <td >Code Salle </td>
		                <td >Adresse centre </td>
		                <td >Email centre </td>
		                <td >telepresence Stagiaire Possible </td>
		               	<td >telepresence Formateur Possible </td>             
		            </tr>
		            <tr>
			            <td>${workload.idSalle}</td>
			            <td>${workload.codeSalle}</td>
			            <td>${workload.adresseCentre}</td>
			            <td>${workload.emailCentre}</td>
			            <td>${workload.telepresenceStagiairePossible}</td>
			            <td>${workload.telepresenceFormateurPossible}</td>
			         </tr>
	            </table>
	            
	</c:forEach>
	
		<form action="SupprimerUneSalle" method="POST">
	
				<label for="idSalle">Id Salle</label>
			  	<input id="idSalle" name="idSalle" type="text" required />
			
			    <input value="Supprimer !" type="submit"/>
	</form>

	<form action="AjouterUneSalleServlet" method="POST">
		
			<table>
				<caption>Création d'une salle</caption>
				
				
				<tr>
				    <td>Code</td>
				    <td><input name="nomStagiaire" type="text" required /></td>
				</tr>
				
				
				<tr>
				    <td>Adresse centre</td>
				    <td><input name="adresseCentre" type="text" required /></td>
				</tr>
				
				<tr>
				    <td>Email centre</td>
				    <td><input name="emailCentre" type="text" required /></td>
				</tr>
				
				<tr>
				    <td>Téléprésence Stagiaire Possible</td>
				    <td><input name="telepresenceStagiairePossible" type="text" required/></td>
				</tr>
				
				<tr>
				    <td>Téléprésence Formateur Possible</td>
				    <td><input name="telepresenceFormateurPossible" type="text" required/></td>
				</tr>
				
				<tr>
				    <td></td>
				    <td><input type="submit" value="Ajouter !"/></td>
				</tr>
			</table>
		
		</form>
		
		<form action="ModifierUneSalleServlet" method="POST">
		
			<table>
				<caption>Modification d'une salle</caption>
				<tr>
				    <td>Id</td>
				    <td><input name="idSalle" type="text" required/></td>
				</tr>
				
				<tr>
				    <td>Code </td>
				    <td><input name="codeSalle" type="text" required/></td>
				</tr>
				
				<tr>
				    <td>Adresse centre</td>
				    <td><input name="adresseCentre" type="text" required /></td>
				</tr>
				
				<tr>
				    <td>Email centre</td>
				    <td><input name="emailCentre" type="text" required /></td>
				</tr>
				
				<tr>
				    <td>Téléprésence Stagiaire Possible</td>
				    <td><input name="telepresenceStagiairePossible" type="text" required/></td>
				</tr>
				
				<tr>
				    <td>Téléprésence Formateur Possible</td>
				    <td><input name="telepresenceFormateurPossible" type="text" required/></td>
				</tr>
				
				
				
				<tr>
				    <td></td>
				    <td><input type="submit" value="Modifier !"/></td>
				</tr>
			</table>
		
		</form>

</body>
</html>