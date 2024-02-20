<%@ include file="common/navigation.jspf"%>
<%@ include file="common/header.jspf"%>
<div class="container">
	<h1>Your Todos</h1>
	<hr></hr>
	<table class="table">
		<thead>
			<th>Description</th>
			<th>TargetDate</th>
			<th>Status</th>
			<th></th>
			<th></th>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.targetdate}</td>
					<td>${todo.isDone}</td>
					<td><a href="delete-todo?id=${todo.id}"
						class="btn btn-warning">Delete</a></td>
					<td><a href="update-todo?id=${todo.id}"
						class="btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todos" class="btn btn-success">Add todo</a>
	
</div>
	<%@ include file="common/footer.jspf"%>
