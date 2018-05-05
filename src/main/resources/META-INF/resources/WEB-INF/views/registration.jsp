<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
        <h2><font color="red">${errorMessage}</font></h2>
        <form:form action="/user/" method="post" modelAttribute="user">
            <table>
                <tr>
                    <td><form:label path="login">Login</form:label></td>
                    <td><form:input path="login"/></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password</form:label></td>
                    <td><form:input type="password" path="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>