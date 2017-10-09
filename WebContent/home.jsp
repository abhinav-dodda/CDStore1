<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
// Getting the SQL driver for JDBC and also setting up MY SQL database schema
String mySQLdriverName = "com.mysql.jdbc.Driver";
String databaseConnectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "assignment1_schema";
String userId = "root";
String password = "Ottawa@2017";

try {
Class.forName(mySQLdriverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
// Declaration of the connection statements
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
 <!-- <body background="notes.jpg"/> -->
 <title>
 Music Bonanza
 </title>
 <head>
 </head>
  <link rel="stylesheet" type="text/css" href="styles/bootstrap-grid.min.css">
 <link rel="stylesheet" type="text/css" href="styles/bootstrap-reboot.min.css">
 <link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="styles/styles.css">
  <body>

<h2 align="center"><font face="Matura MT Script Capitals" color="orange" size="200"><strong> Music Bonanza </strong></font></h2>

<table align="center" border="1" id="t1">

<tr>

</tr>
<tr bgcolor="#4487B2">
<td align="center"><font face="verdana"><b>Cdid</b></font></td>
<td align="center"><font face="vedana"><b>Title</b></font></td>
<td align="center"><font face="verdana"><b>Price</b></font></td>
<td align="center"><font face="verdana"><b>Category</b></font></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(databaseConnectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sqlQuery ="SELECT * FROM cd";

resultSet = statement.executeQuery(sqlQuery);
while(resultSet.next()){
%>
<tr>

<td><font face ="verdana" color="black"><strong><%=resultSet.getString("Cdid") %></strong></font></td>
<td><font face="verdana" color="black"><strong><%=resultSet.getString("Title") %></strong></font></td>
<td><font face="verdana" color="black"><strong><%=resultSet.getString("Price") %></strong></font></td>
<td><font face="verdana" color="black"><strong><%=resultSet.getString("Category") %></strong></font></td>
</tr>
<% 
}
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>	
</body>