<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form method="post" modelAttribute="person">

	<label for="firstName">First Name:</label>
	<form:input path="firstName" />
	
	<label for="lastName">Last Name:</label>
	<form:input path="lastName" />
	
	<label for="age">Age:</label>
	<form:input path="age" />
	
	
</form:form>

<table>
	<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${persons}" var="p">
			<tr>
				<th>${p.firstName}</th>
				<th>${p.lastName}</th>
				<th>${p.age}</th>
			</tr>
		</c:forEach>
	</tbody>
</table>