<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 15/5/2025
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Login</title>
</head>
<body>
<h1>Login de Usuario</h1>
<div>
    <form action="/proyectoCookies/login" method="post">
        <div>
            <label for="username">Nombre de usuarios: </label>
            <div>
                <input type="text" name="username" id="username">
            </div>
        </div>
        <div>
        <label for pass="pass">Password</label>
        <div>
            <input type="password" name="password" id="pass">
        </div>
        </div>
        <div>
            <input type="submit"value="Enviar">
        </div>
    </form>
</div>
</body>
</html>
