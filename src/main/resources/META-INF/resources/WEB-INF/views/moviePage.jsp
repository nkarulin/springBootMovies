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

        <br>
        <table>
            <c:forEach items="${movie.comments}" var="comment" varStatus="count">
            <tr><td>
                <c:out value="${comment.author}: ${comment.text}"/>
            </td></tr>
            </c:forEach>
        </table>
        <br>
        <textarea name="commentText" form="commentform">Enter your comment here...</textarea>
        <form action="/movies/${movie.id}/comment/" method="post" id="commentform">
            <input type="submit" value="Comment" />
        </form>
    </body>
</html>