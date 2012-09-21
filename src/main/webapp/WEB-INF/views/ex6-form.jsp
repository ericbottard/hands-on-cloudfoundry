<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Hands On CloudFoundry &middot; exercise 5</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="css/custom.css"/>

    <script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/custom.js"></script>
</head>
<body>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Hands On CloudFoundry</a>

            <ul class="nav">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" data-target="instructions" href="#">
                        Instructions
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu" id="instructions">
                        <li>
                            <a href="https://github.com/ericbottard/hands-on-cloudfoundry/blob/master/README.fr.md#exercice-1-entre-5-et-30-mins"
                               rel="external">
                                Exercise 1
                            </a>
                        </li>
                        <li>
                            <a href="https://github.com/ericbottard/hands-on-cloudfoundry/blob/master/README.fr.md#exercice-2-20-mins"
                               rel="external">
                                Exercise 2
                            </a>
                        </li>
                        <li>
                            <a href="https://github.com/ericbottard/hands-on-cloudfoundry/blob/master/README.fr.md#exercice-3-10-mins"
                               rel="external">
                                Exercise 3
                            </a>
                        </li>
                        <li>
                            <a href="https://github.com/ericbottard/hands-on-cloudfoundry/blob/master/README.fr.md#exercice-4-15-mins"
                               rel="external">
                                Exercise 4
                            </a>
                        </li>
                        <li>
                            <a href="https://github.com/ericbottard/hands-on-cloudfoundry/blob/master/README.fr.md#exercice-5-15-mins"
                               rel="external">
                                Exercise 5
                            </a>
                        </li>
                        <li>
                            <a href="https://github.com/ericbottard/hands-on-cloudfoundry/blob/master/README.fr.md#exercice-6"
                               rel="external">
                                Exercise 6
                            </a>
                        </li>
                        <li>
                            <a href="https://github.com/ericbottard/hands-on-cloudfoundry/blob/master/README.fr.md#exercice-7"
                               rel="external">
                                Exercise 7
                            </a>
                        </li>
                    </ul>
                </li>
                <li><a href="<c:url value="/ex4" />">Exercise 4</a></li>
                <li><a href="<c:url value="/ex5" />">Exercise 5</a></li>
                <li><a href="<c:url value="/ex6" />">Exercise 6</a></li>
                <li><a href="<c:url value="/ex6" />">Exercise 7</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container">
    <div class="alert alert-info">
        <p><i class="icon-info-sign"></i> Add another datasource which will replicate the first one contents.</p>

        <p>
            <a href="<c:url value="https://github.com/ericbottard/hands-on-cloudfoundry/blob/master/README.fr.md#exercice-6-15-mins" />"
               class="btn btn-primary btn-small"
               rel="external">
                See exercise 6
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