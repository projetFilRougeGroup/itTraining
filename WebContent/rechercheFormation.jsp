<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ChercheUneFormationServlet" method="POST">
	
		<table style="border: 2px solid green">
		
			<caption>La recherche d'une formation !</caption>
			
			<tr>
			    <td>Id de la formation</td>
			    <td><input name="idFormation" type="text"/></td>
			</tr>
			
			<tr>
			    <td>nom de la formation</td>
			    <td><input name="nomFormation" type="text"/></td>
			</tr>
			
			<tr>
			    <td></td>
			    <td><input type="submit" value="Chercher !"/></td>
			</tr>
		</table>
	
	</form>



</body>
</html>