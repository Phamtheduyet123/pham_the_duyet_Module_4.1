<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/25/2022
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>SandWish Condiments</h1>
  <form action="/save" method="get">
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts
  <hr>
    <input type="submit" onclick="hello12()" value="Save">
  </form>
  <p>${condiment}</p>
  </body>
</html>
</script>
