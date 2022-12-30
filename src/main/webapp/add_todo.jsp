<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="component/navbar.jsp"%>

	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Add TODo</h3>
						<form action="add_todo" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Name</label> <input type="text"
									class="form-control" name="name" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">TODO</label> <input type="text"
									class="form-control" name="todo" aria-describedby="emailHelp">
							</div>


							<div class="form-group">
								<label for="inputState">Status</label> <select
									class="form-control" name="status">
									<option selected>--Select--</option>
									<option>Pending</option>
									<option>Complete</option>
								</select>
							</div>
							<div class="text-center">

								<button type="submit" class="btn btn-primary">ADD</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>