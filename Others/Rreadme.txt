I have provided .war file, database_table.txt, project folder created in Eclipse.
/hw4/Webcontent/WEB-INF contans ojdbc.jar file and all struts .jar files used here.
/hw4/Webcontent folder contains all .jsp file and other related files (.html, .css, .jpg etc)
/hw4/src contains all .java files

database_table.txt contains table definition. Same as hw4.
Constructor method of OracleConnect.java contains username and password of gmu oracle. 

Run Instruction:
1. Copy and paste hw_struts.war in to the tomcat wabapps direcotry.
2. Start the server.
3. Open a browser and type http://localhost:8080/hw_struts/survey.jsp to see the input page.

Input page criteria implemented:
1. Required field: first name, last name, phone number and student ID.
2. Also need to click on radio button and at least two check box 
3. Ajax has been included. 
4. Using javascript it has been validated that phone number will contain number only.
5. Email regex was not added.
6. url and email could be validated using regex inside javascript. not implemented though.





