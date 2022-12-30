<%@page import="com.entity.ToDoDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.TodoDao"%>
<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ToDoApp</title>
<%@include file="component/allcss.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>


	<h1 class="text-center text-success">TODO-APP</h1>
	<%
	String sucMsg = (String) session.getAttribute("sucMsg");
	String errMsg = (String) session.getAttribute("errMsg");
	if (sucMsg != null) {
	%>
	<div class="alert alert-success"><%=sucMsg%></div>
	<%
	}
	session.removeAttribute(sucMsg);
	%>
	<%
	if (errMsg != null) {
	%>
	<div class="alert alert-danger"><%=errMsg%></div>
	<%
	}
	session.removeAttribute(errMsg);
	%>
	<div class="container">

		<table class="table table-striped" border="2px">
			<thead class="bg-success text-white">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">ToDo</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>

				<%
				TodoDao dao = new TodoDao(DBConnect.getConn());
				List<ToDoDetails> todo = dao.getTodo();
				for (ToDoDetails t : todo) {
				%>
				<tr>
					<th scope="row"><%=t.getId()%></th>
					<td><%=t.getName()%></td>
					<td><%=t.getTodo()%></td>
					<td><%=t.getStatus()%></td>
					<td><a href="edit.jsp?id=<%=t.getId()%>"
						class="btn btn-sm btn-success">Edit</a> <a
						href="deleteServlet?id=<%=t.getId()%>"
						class="btn btn-sm btn-danger">Delete</a></td>
				</tr>
				<%
				}
				%>

			</tbody>
		</table>
	</div>
</body>
</html>