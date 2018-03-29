<%-- Author = Monjura Afrin Rumi --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Information</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<%@ page import="hw4.StudentBean" %>
	<jsp:useBean id="studentbean" class="hw4.StudentBean" scope="session">
 		<jsp:setProperty name="studentbean" property="*"/>
	</jsp:useBean>
	
	<table align="center">
		<tr>
			<td><label> First Name : <jsp:getProperty name="studentbean" property="fname"/>				 				
			</label></td>
			<td><label> Middle Name : <jsp:getProperty name="studentbean" property="mname"/>				
			</label></td>				
			<td><label> Last Name : <jsp:getProperty name="studentbean" property="lname"/>				
			</label></td>				
		</tr>			  
		<tr>
			<td><label> Street Address : <jsp:getProperty name="studentbean" property="address"/>				
			</label></td>							  
			<td><label> Zip Code : <jsp:getProperty name="studentbean" property="zip_code"/>				
			</label></td>							  
			<td><label> City : <jsp:getProperty name="studentbean" property="city"/>
			</label></td>
		</tr>
		<tr>
			<td><label> State : <jsp:getProperty name="studentbean" property="state"/>
			</label></td>			  
			<td><label> Phone Number : <jsp:getProperty name="studentbean" property="phone"/>					 
			</label></td>
			<td><label> Student ID : <jsp:getProperty name="studentbean" property="student_id"/>
			</label></td>			  
		</tr>
		<tr>
			<td><label> Email : <jsp:getProperty name="studentbean" property="email"/>				
			</label></td>				
			<td><label> URL : <jsp:getProperty name="studentbean" property="url"/>				 				
			</label></td>			  
			<td><label> Date of Survey : <jsp:getProperty name="studentbean" property="date"/>
			</label></td>
		</tr>			  
		<tr>
			<td><label> Graduation Month : <jsp:getProperty name="studentbean" property="gmonth"/>				
			</label></td>				
			<td><label> Graduation Year : <jsp:getProperty name="studentbean" property="gyear"/>				 				
			</label></td>			  				
		</tr>
	</table>
			
	<table align="center">
		<tr>
			<td>Things liked most about the campus: 
				<% String[] l=studentbean.getLike();
					String mostliked="";
				if (l[0]==null){
					mostliked="None Provided";
				}%>
				<%= mostliked%>
				<%for(int i=0;i<l.length;i++)
				{						
					if (l[i]==null)
					{
						break;
					}
					
					if (i!=5 && l[i+1]!=null ){
						mostliked=l[i]+", ";
					}
					else 
					{
						mostliked=l[i];
					}%>
					<%= mostliked%>
				<%}
				%>
			</td> 
		</tr>				  				  
		<tr>
			<td>The reason tp become interested in GMU: 
				<jsp:getProperty name="studentbean" property="interested"/></td>				
		</tr>						
		<tr>
			<td>Recommend this school to other students: 
				<jsp:getProperty name="studentbean" property="recommend"/></td>				
		</tr>
	</table>	
		
</body>
</html>
