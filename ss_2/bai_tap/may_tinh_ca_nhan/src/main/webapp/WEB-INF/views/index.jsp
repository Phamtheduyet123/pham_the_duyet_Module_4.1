<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/25/2022
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/hello" method="get">
    <input id="number" type="number" name="p">

    <input id="last" type="number" name="p1">


    <button type="submit" name="q" value="Addition">Addition(+)</button>


    <button type="submit" name="q" value="Subtraction">Subtraction(-)</button>

    <button type="submit" name="q" value="Multiplication">Multiplication(X)</button>


    <button type="submit" name="q" value="Division">Division(/)</button>

</form>
<p>${result}</p>

</body>
</html>
