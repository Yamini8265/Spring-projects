<%@ include file="common/navigation.jspf"%>
<%@ include file="common/header.jspf"%>
<div class="container"></div>
<h1>Enter Todo details</h1>
<form:form method="post" modelAttribute="todo">

	<fieldset class="mb-3">
		<form:label path="description">Description</form:label>
		<form:input type="text" path="description" />
		<form:errors path="description" cssClass="text-warning"></form:errors>
	</fieldset>
	<fieldset class="mb-3">
		<form:label path="targetdate">Target Date</form:label>
		<form:input type="text" path="targetdate" />
	</fieldset>

	<form:input type="hidden" path="isDone" />
	<form:input type="hidden" path="id" />

	<input type="submit" class="btn btn-success">
</form:form>
<%@ include file="common/footer.jspf"%>

<script
	src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
	$('#targetdate').datepicker({
		format : 'yyyy-mm-dd',
	});
</script>
