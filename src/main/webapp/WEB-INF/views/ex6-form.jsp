<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">
<head>
    <title>Hands On CloudFoundry &middot; exercise 6 &amp; 7</title>
    <c:import url="head.jsp" />
</head>
<body>
<c:import url="header.jsp" />
<div class="container">
    <div class="alert alert-info">
        <p><i class="icon-info-sign"></i> Add another datasource which will replicate the first one contents.</p>
        <p>
            <a href="<c:url value="https://github.com/ericbottard/hands-on-cloudfoundry/blob/master/README.fr.md#exercice-6-15-mins" />"
               class="btn btn-primary btn-small"
               rel="external">
                See exercise 6
            </a> and
            <a href="<c:url value="https://github.com/ericbottard/hands-on-cloudfoundry/blob/master/README.fr.md#exercice-7-20-mins" />"
               class="btn btn-primary btn-small"
               rel="external">
                exercise 7
            </a>

        </p>
    </div>

    <form:form method="post" cssClass="form-horizontal well">
        <legend>Persons backup</legend>

        <div class="control-group">
            <div class="controls">
                <input type="submit" class="btn" value="Copy" />
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
                    <td colspan="3">Nobody backed up... yet.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach items="${persons}" var="p">
                    <tr>
                        <th><c:out value="${p.firstName}" /></th>
                        <th><c:out value="${p.lastName}" /></th>
                        <th><c:out value="${p.age}" /></th>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</div>

</body>
</html>