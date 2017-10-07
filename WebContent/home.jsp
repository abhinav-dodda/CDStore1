<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String jdbcDriver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String databaseName = "cdstore";
String user = "root";
String pswd = "";

try {
Class.forName(jdbcDriver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
%>
<h2 align="center"><font><strong>Soul Style Records!!</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<body/>
<tr>

</tr>
<tr bgcolor="#c3d6f4">
<td><b>CD ID</b></td>
<td><b>Title</b></td>
<td><b>Price</b></td>
<td><b>Category</b></td>
</tr>
<%
try{ 
conn = DriverManager.getConnection(connectionUrl+databaseName, user, pswd);
stmt=conn.createStatement();
String query ="SELECT * FROM cd";

rs = stmt.executeQuery(query);
while(rs.next()){
%>
<tr>

<td><%=rs.getString("Cdid") %></td>
<td><%=rs.getString("Title") %></td>
<td><%=rs.getString("Price") %></td>
<td><%=rs.getString("Category") %></td>
</tr>
<% 
}
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>