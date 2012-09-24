<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="<c:url value="/" />">Hands On CloudFoundry</a>

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
                            <a href="https://github.com/ericbottard/hands-on-cloudfoundry/blob/master/README.fr.md#exercice-6-15-mins"
                               rel="external">
                                Exercise 6 &amp; 7
                            </a>
                        </li>
                    </ul>
                </li>
                <li><a href="<c:url value="/ex4" />">Exercise 4</a></li>
                <li><a href="<c:url value="/ex5" />">Exercise 5</a></li>
                <li><a href="<c:url value="/ex6" />">Exercise 6 &amp; 7</a></li>
            </ul>
        </div>
    </div>
</div>