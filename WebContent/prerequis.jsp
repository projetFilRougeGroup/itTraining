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
 <link rel="stylesheet" href="css/prerequis.css"> 
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
<link rel="stylesheet" type="text/css" href="css/rechercheFormation.css">
 <link rel="stylesheet" href="css/tableaux.css"> 
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" /> -->
<title>Prérequis</title>
</head>
<body>

<div>
		<!-- formulaire d'Affichage de tout les prérequis -->
		<form action="AfficherToutLesPrerequisServlet" method="POST">
			
				<table>
				
					<tr>
					    <td><input type="submit" value="Afficher les prérequis !"/></td>
					</tr>
					
				</table>
			
		</form>
		
		<br />
		
		<div>
	<c:forEach var="workload" items="${resultRecherchePrerequis}">
	
				<table>
		            <tr> 
		            
		            	<td>id Prérequis</td>
		                <td >Description prérequis</td>
		                <td>Quizz</td>
		                <td>Action</td>
		                
		             
		            </tr>
		            <tr>
			            <td>${workload.idPrerequis}</td>
			            <td>${workload.descriptionPrerequis}</td>
			            <td>${workload.quizz}</td>
			            
			            <td>
			            
			            	<form action="supprimerLePrerequisServlet" method="POST">
			            		<input name="idPrerequis" value="${workload.idPrerequis }" id="${workload.idPrerequis }" type="text"/> 		            		
			            	 <button type="submit" >
			            		<img src="images/delete.png" style="width: 35px; cursor:pointer" alt="Supprimer !" title="Supprimer !"/>
			            		</button>
			            		
			            	</form>
			            	
			            	
			            </td>
			        </tr>
		            
		            
	            </table>
	</c:forEach>
		</div>


		<!-- Formulaire d'ajouter des prérequis -->
		<form action="AjouterUnPrerequisServlet" method="POST">
			
				 <table border="1px solid green">
					<caption>Création d'un Prérequis</caption>
					
					
					<tr>
					    <td>Description de prérequis</td>
					    <td><input name="descriptionPrerequis" type="text" required/></td>
					</tr>
					<tr>
					    <td>Quizz</td>
					    <td><input name="quizz" type="text" required/></td>
					</tr>
					
					<tr>
					    
					    <td><input type="submit" value="Ajouter prérequis !"/></td>
					    <td><input type="reset" value="Annuler" /></td>
					</tr>
				</table>
			
		</form>
		
		<br/>
			<form action="ModifierLePrerequisServlet" method="POST">
				        <table border="1px solid green">
				        <caption>Modification du prérequis !</caption>
				         <tr>
						    <td>id prérequis</td>
						    <td><input name="idPrerequis" type="text" required/></td>
						</tr>		
				         <tr>
						    <td>Description de prérequis</td>
						    <td><input name="descriptionPrerequis" type="text" required/></td>
						</tr>
						<tr>
						    <td>Quizz</td>
						    <td><input name="quizz" type="text" required/></td>
						</tr>
				            		
				           </table>    		
				       <input type="submit" value="Modifier le prérequis !" />      	
				          	
			</form>
		
						
</div>

		

</body>
</html>