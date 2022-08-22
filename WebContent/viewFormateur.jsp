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
<style>
        table {
            width 38%
            font-size: 20px;
            height: 100%;
            table-layout: fixed;
        }
  
        td {
        width:fixed
            border: 1px solid black;
            text-align: center;
            padding: 10px;
        }
  
        tr:nth-child(even) {
            background-color: #00cf45;
        }
  
        h1 {
            color: green;
        }
        .label {
  color: white;
  padding: 8px;
  font-family: Arial;
}
.success {background-color: #04AA6D;}
    </style>
</head>

<body>
<table >
            
                
                  <span class="label success">Professor Records</span> 
            
 
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
				
            <tr>
                

		          
		            <tr style="background-color:lightgrey;">
			            <td>${workload.idEnseignant}</td>
			            <td>${workload.adresseEnseignant  }</td>
			            <td>${workload.skill}</td>
			            <td>${workload.emailEnseignant }</td>
			            <td>${workload.nomEnseignant }</td>
			            <td>${workload.prenomEnseignant }</td>
			         
			            <td>${workload.telEnseignant }</td>
			            
		            </tr>
	            
	</c:forEach>
</div>
</table>
</body>
</html>
           