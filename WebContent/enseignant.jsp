<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.List, java.text.*" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="css/rechercheFormation.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

<title>Enseignant !</title>
</head>
<body>



<h1>Partie Enseignant CRUD !</h1>
<c:url var="thisURL" value="index.html">
</c:url>
<a href="<c:out value="${thisURL}"/>">Retour à l'accueil</a>

	<form action="ChercheUnEnseignantServlet" method="POST">
		
			
				    <label for="rech">
				    Recherche un enseignant !
				    </label>
				    <input id="rech" name="keyWord" type="text" placeholder="Mots clé .."/>
				    <input type="submit" value="Chercher !"/>
	</form>
	
	<br />
	<c:forEach var="workload" items="${resultRechercheEnseignant}">
	
				<table>
		            <tr> 
		            
		            	<td>id Enseignant</td>
		                <td >Nom </td>
		                <td>Prénom </td>
		                <td >Tél </td>
		                <td>Email </td>
		                <td >Adresse </td>		             
		            </tr>
		            <tr>
			            <td>${workload.idEnseignant}</td>
			            <td>${workload.nomEnseignant}</td>
			            <td>${workload.prenomEnseignant}</td>
			            <td>${workload.telEnseignant}</td>
			            <td>${workload.emailEnseignant}</td>
			            <td>${workload.adresseEnseignant}</td>
		            </tr>
	            </table>
	</c:forEach>
	
		<form action="SupprimerUnEnseignantServlet" method="POST">
	
				<label for="idEnseignant">Id de l'enseignant</label>
			  	<input id="idEnseignant" name="idEnseignant" type="text"/>
			
			    <input value="Supprimer !" type="submit"/>
	</form>

	<form action="AjouterUnEnseignantServlet" method="POST">
		
			<table>
				<caption>Création d'un enseignant</caption>
				
				
				<tr>
				    <td>Nom </td>
				    <td><input name="nomEnseignant" type="text"/></td>
				</tr>
				<tr>
				    <td>Prénom  </td>
				    <td><input name="prenomEnseignant" type="text"/></td>
				</tr>
				
				<tr>
				    <td>Email  </td>
				    <td><input name="emailEnseignant" type="text"/></td>
				</tr>
				
				<tr>
				    <td>Tél  </td>
				    <td><input name="telEnseignant" type="text"/></td>
				</tr>
				
				<tr>
				    <td>Adresse  </td>
				    <td><input name="adresseEnseignant" type="text"/></td>
				</tr>
				
				<tr>
				    <td></td>
				    <td><input type="submit" value="Ajouter !"/></td>
				</tr>
			</table>
		
		</form>
		
		<form action="ModifierUnEnseignantServlet" method="POST">
		
			<table>
				<caption>Modification d'un enseignant</caption>
				<tr>
				    <td>Id</td>
				    <td><input name="idEnseignant" type="text"/></td>
				</tr>
				
				<tr>
				    <td>Nom </td>
				    <td><input name="nomEnseignant" type="text"/></td>
				</tr>
				<tr>
				    <td>Prénom  </td>
				    <td><input name="prenomEnseignant" type="text"/></td>
				</tr>
				
				<tr>
				    <td>Email  </td>
				    <td><input name="emailEnseignant" type="text"/></td>
				</tr>
				
				<tr>
				    <td>Tél  </td>
				    <td><input name="telEnseignant" type="text"/></td>
				</tr>
				
				<tr>
				    <td>Adresse  </td>
				    <td><input name="adresseEnseignant" type="text"/></td>
				</tr>
				
				<tr>
				    <td></td>
				    <td><input type="submit" value="Modifier !"/></td>
				</tr>
			</table>
		
		</form>

</body>
</html>