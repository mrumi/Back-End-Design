<%-- Author = Monjura Afrin Rumi --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Survey Feedback</title>
</head>
<body>		
	<%@ page import="hw4.DataBean" %>
	<jsp:useBean id="databean" class="hw4.DataBean" scope="session">
 		<jsp:setProperty name="databean" property="*"/>
	</jsp:useBean>
	
	<%@ page import="hw4.StudentBean" %>
	<jsp:useBean id="studentbean" class="hw4.StudentBean" scope="session">
 		<jsp:setProperty name="studentbean" property="*"/>
	</jsp:useBean>
			
	<p>Hello, <strong><jsp:getProperty name="studentbean" property="fname"/></strong>
	<br>Thanks for filling up our survey form. Your information has been uploaded.
	</P>
	<P> Statistic Properties of your data</p>				
	<p>Mean: <strong><jsp:getProperty name="databean" property="mean"/></strong></p>
	<p>Standard Deviation: <strong><jsp:getProperty name="databean" property="std"/></strong></P>		
	<p>All student who filled up the survey</p>
	<ul><%String id= studentbean.getAllid();
	String middle[]=id.split(",");
	for(int i=0;i<middle.length;i++)
	{
		String eachid=middle[i];%>
		<li><a href="StudentServiceServlet?id=<%= eachid %>"><%= eachid %></a></li>		  	
	<%}
	
	%>
	</ul>
</body>
</html>