<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>
    <style>
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
        <h2>${movie.title} (${movie.year})</h2>
        <div class="movie" style="background-image:url('/images/${movie.image}')">
            <p><span style="background-color: #000003; color:white">
                <c:out value="${movie.title} (${movie.year})"/>
            </span></p>
        </div></td>

        <br>
        <sec:authorize access="hasAnyRole('ADMIN')">
            <a href="/movies/delete/${movie.id}">DELETE THE MOVIE ${movie.title}</a>
        </sec:authorize>
    </body>
</html>