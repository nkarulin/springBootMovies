<html>
<head></head>
<body>
   <h1>Login</h1>

   <c:if test="${param.error != null}">
        <h2><font color="red">Bad credentials!</font></h2>
   </c:if>

   <h2><font color="red">${errorMessage}</font></h2>
   <h2><font color="blue">${infoMessage}</font></h2>
   <form name='f' action="/user/login" method='POST'>
      <table>
         <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
  </form>
</body>
</html>