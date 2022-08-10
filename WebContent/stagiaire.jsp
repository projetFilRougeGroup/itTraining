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
<title>Stagiaire !</title>
</head>
<body>

<h1>Partie Stagiaire CRUD !</h1>
<c:url var="thisURL" value="index.html">
</c:url>
<a href="<c:out value="${thisURL}"/>">Retour à l'accueil</a>

	<form action="ChercheUnStagiaireServlet" method="POST">
		
			
				    <label for="rech">
				    Recherche un stagiaire !
				    </label>
				    <input id="rech" name="keyWord" type="text" placeholder="Mots clé .."/>
				    <input type="submit" value="Chercher !"/>
	</form>
	
	<br />
	<c:forEach var="workload" items="${resultRechercheStagiaire}">
	
				<table>
		            <tr> 
		            
		            	<td>id Stagiaire</td>
		                <td >Nom </td>
		                <td>Prénom </td>
		                <td >Tél </td>
		                <td>Email </td>
		                <td >Adresse </td>		             
		            </tr>
		            <tr>
			            <td>${workload.idStagiaire}</td>
			            <td>${workload.nomStagiaire}</td>
			            <td>${workload.prenomStagiaire}</td>
			            <td>${workload.telStagiaire}</td>
			            <td>${workload.emailStagiaire}</td>
			            <td>${workload.adresseStagiaire}</td>
		            </tr>
	            </table>
	</c:forEach>
	
		<form action="SupprimerUnStagiaireServlet" method="POST">
	
				<label for="idStagiaire">Id de Stagiaire</label>
			  	<input id="idStagiaire" name="idStagiaire" type="text"/>
			
			    <input value="Supprimer !" type="submit"/>
	</form>

	<form action="AjouterUneStagiaireServlet" method="POST">
		
			<table>
				<caption>Création d'un stagiaire</caption>
				
				
				<tr>
				    <td>Nom </td>
				    <td><input name="nomStagiaire" type="text"/></td>
				</tr>
				<tr>
				    <td>Prénom  </td>
				    <td><input name="prenomStagiaire" type="text"/></td>
				</tr>
				
				<tr>
				    <td>Email  </td>
				    <td><input name="emailStagiaire" type="text"/></td>
				</tr>
				
				<tr>
				    <td>Tél  </td>
				    <td><input name="telStagiaire" type="text"/></td>
				</tr>
				
				<tr>
				    <td>Adresse  </td>
				    <td><input name="adresseStagiaire" type="text"/></td>
				</tr>
				
				<tr>
				    <td></td>
				    <td><input type="submit" value="Ajouter !"/></td>
				</tr>
			</table>
		
		</form>
		
		<form action="ModifierUnStagiaireServlet" method="POST">
		
			<table>
				<caption>Modification d'un stagiaire</caption>
				<tr>
				    <td>Id</td>
				    <td><input name="idStagiaire" type="text"/></td>
				</tr>
				
				<tr>
				    <td>Nom </td>
				    <td><input name="nomStagiaire" type="text"/></td>
				</tr>
				<tr>
				    <td>Prénom  </td>
				    <td><input name="prenomStagiaire" type="text"/></td>
				</tr>
				
				<tr>
				    <td>Email  </td>
				    <td><input name="emailStagiaire" type="text"/></td>
				</tr>
				
				<tr>
				    <td>Tél  </td>
				    <td><input name="telStagiaire" type="text"/></td>
				</tr>
				
				<tr>
				    <td>Adresse  </td>
				    <td><input name="adresseStagiaire" type="text"/></td>
				</tr>
				
				<tr>
				    <td></td>
				    <td><input type="submit" value="Modifier !"/></td>
				</tr>
			</table>
		
		</form>
</body>
</html>