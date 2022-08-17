<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<%@ page import="com.training.entites.Enseignant"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="700px" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=4 align="center"
                    style="background-color:teal">
                    <b>Professor Records</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
               
               <td><b>Id</b></td>
               <td><b>Address</b></td>
                <td><b>Skill</b></td>
                <td><b>Email</b></td>
                <td><b>Nom</b></td>
                <td><b>Prenom</b></td>
                <td><b>Telephone</b></td>
            </tr>
             
<div>
	<h3>Nombre de formateur trouvé: ${fn:length(formList)}</h3>
	<br />
	<c:forEach var="workload" items="${formList}">
				<table width="700px" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=4 align="center"
                    style="background-color:teal">
		          
		            <tr style="background-color:lightgrey;">
			            <td>${workload.idEnseignant}</td>
			            <td>${workload.adresseEnseignant  }</td>
			            <td>${workload.skill}</td>
			            <td>${workload.emailEnseignant }</td>
			            <td>${workload.nomEnseignant }</td>
			            <td>${workload.prenomEnseignant }</td>
			         
			            <td>${workload.telEnseignant }</td>
			            
		            </tr>
	            </table>
	</c:forEach>
</div>

</table>
</body>
</html>
           