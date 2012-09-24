<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Hands On CloudFoundry &middot; exercise 5</title>
    <c:import url="head.jsp" />
</head>
<body>
<c:import url="header.jsp" />
<div class="container">
    <div class="alert alert-info">
        <p><i class="icon-info-sign"></i> Add a first datasource where people can be stored.</p>

        <p>
            <a href="<c:url value="https://github.com/ericbottard/hands-on-cloudfoundry/blob/master/README.fr.md#exercice-5-15-mins" />"
               class="btn btn-primary btn-small"
               rel="external">
                See exercise 5
            </a>
        </p>
    </div>

    <form:form method="post" modelAttribute="person" cssClass="form-horizontal well">
        <legend>Person store</legend>

        <div class="control-group">
            <label class="control-label" for="firstName">First Name:</label>

            <div class="controls">
                <form:input path="firstName"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="lastName">Last Name:</label>

            <div class="controls">
                <form:input path="lastName"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="age">Age:</label>

            <div class="controls">
                <form:input path="age"/>
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <input type="submit" class="btn" value="Send" />
            </div>
        </div>

    </form:form>

    <table class="table table-bordered table-striped table-hover">
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${empty persons}">
                <tr>
                    <td colspan="3">Nobody... yet.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach items="${persons}" var="p">
                    <tr>
                        <th>${p.firstName}</th>
                        <th>${p.lastName}</th>
                        <th>${p.age}</th>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</div>
</body>
</html>