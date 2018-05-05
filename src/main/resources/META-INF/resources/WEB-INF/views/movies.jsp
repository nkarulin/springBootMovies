<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication var="user" property="principal" />

<html>
    <style>
        .movieLink {
            color: white;
            text-decoration: none;
            a:visited {
                color: white;
            }
        }

        .movie {
            background-position: center;
            height: 250px;
            width: 200px;
            overflow: hidden;
            background-size: cover
        }
    	table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            margin: 0 auto;
        }
        td {
            text-align: center;
            padding: 4px;
        }

    </style>
    <head>
        <title>Movies</title>
    </head>
    <body>

        <sec:authorize access="isAuthenticated()">
            Log in as: ${user.username} (<a href="<c:url value="/logout" />">Logout</a>)
        </sec:authorize>

        <sec:authorize access="!isAuthenticated()">
            Anonymous  <a href="/user/login">Log In</a> / <a href="/user/registration">Register</a>
        </sec:authorize>

        <br>

        <table>
        <tr>
            <c:forEach items="${movies}" var="movie" varStatus="count">
                <td>
                <div class="movie" style="background-image:url('/images/${movie.image}')">
                    <p><span style="background-color: #000003; color:white">
                        <a href="/movies/${movie.id}" class="movieLink">
                            <c:out value="${movie.title} (${movie.year})"/>
                        </a>
                    </span></p>
                </div></td>

                <c:if test = "${count.count % 3 == 0}">
                    </tr><tr>
                </c:if>
            </c:forEach>
            </tr>
        </table>

        <br><br>
        <form action="management/add">
            <input type="submit" value="Add new Movie" />
        </form>
    </body>
</html>