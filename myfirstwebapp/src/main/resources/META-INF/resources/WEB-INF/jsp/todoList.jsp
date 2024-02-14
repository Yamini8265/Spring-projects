<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

	<head>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		<title>
			Todos Page
		</title>
		</head>
		<body>
		<div class="container">
		<h1>Your Todos</h1>
		<hr></hr>
        <table class="table">
			<thead>
				<th>Id</th>
				<th>Description</th>
				<th>TargetDate</th>
				<th>Status</th>
				<th></th>
				<th></th>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.description}</td>
						<td>${todo.targetdate}</td>
						<td>${todo.isDone}</td>
						<td><a href ="delete-todo?id=${todo.id}" class = "btn btn-warning">Delete</a></td>
						<td><a href="update-todo?id=${todo.id}" class = "btn btn-success">Update</a></td>
				 	</tr>
		  		</c:forEach>
		 	</tbody>
		</table>
		<a href = "add-todos" class="btn btn-success">Add todo</a>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
	</div>
</html>
