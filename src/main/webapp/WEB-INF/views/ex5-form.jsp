<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Exercise 5 &middot; 1 datasource</title>
</head>
<body>

<form:form method="post" modelAttribute="person">

    <label for="firstName">First Name:</label>
    <form:input path="firstName" />

    <label for="lastName">Last Name:</label>
    <form:input path="lastName" />

    <label for="age">Age:</label>
    <form:input path="age" />

    <input type="submit" />
</form:form>

<table>
    <c:if test="${not empty justAdded}">
        <p>Congrats, you have just added <c:out value="${justAdded.firstName}" /></p>
    </c:if>
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


</body>
</html>