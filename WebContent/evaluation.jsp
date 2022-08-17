<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
      
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>

    </head>
    <body>
        <form action="AjouterEvaluationServlet" method="POST">
        <table>
			<caption>Evalution Session</caption>
			
			
			<tr>
			    <td>SessionId</td>
			    <td><input name="session id" type="text"/></td>
			</tr>
				
			
			
			<tr>
			
			    
			    
			    
         <td>    <label for="datepicker">Date debut de session:</label></td>
              <td>  <input type="text" name="selDate" id="datepicker"><td>
            
            
        
        <p>
            The chosen date is <%= request.getParameter("selDate") %>
        </p>
        </tr>
				
		
			
				
					</table>   
			
				 <input type="submit" value="Submit"> 
		</form>
			   
        
        
        
        
        
       
            
    </body>
</html>