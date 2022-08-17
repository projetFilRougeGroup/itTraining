<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>



<html>
<head>
<meta charset="ISO-8859-1">
<style>
ul {
margin: 5;
padding: 5;
background-color: #333;
}
li {
float: left;
}
li v {
color: white;
text-align: center;
padding: 5;
}
li v:hover:not(.active) {
background-color: #111;
}
.active {
background-color: #4CAF50;
}
</style>
</head>
<body>

<h1>Ajout formateur</h1>
		<form action="AjouterformateurServlet" method="POST">
			

<!--  idEnseignant: 	<input type="text" name="idEnseignant"/>-->

<table>
<tr><td>Name Of Prof.:</td> <td><input type="text" name="nomEnseignant"/></td></tr>
<tr><td>Prenom Prof.: 	</td><td> <td><input type="text" name="prenomEnseignant"/></td></tr>
<tr><td>Telephone: 		</td><td> <input type="text" name="telEnseignant"/></td></tr>
<tr><td>Email: 			</td><td> <input type="text" name="emailEnseignant"/></td></tr>
<tr><td>Address: 		</td><td> <input type="text" name="adresseEnseignant"/></td></tr>
<tr><td>Skill: 		</td><td> <input type="text" name="skill"/></td></tr>
<td><input type="submit" value="Ajouter !"/></td>
			
		</table>	
		<a href="SearchFormateur.jsp">Trouver Formateur</a>
		
</body>
</html>