<%--
  Created by IntelliJ IDEA.
  User: quocnna
  Date: 7/23/2022
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/save"
      method="POST" novalidate="novalidate" enctype="multipart/form-data">
    <input type="hidden" name="id" value="1"/>
    <div>
        <label>Name</label>
        <input type="text" name="name"/>
    </div>
    <div>
        <label>Description</label>
        <input type="text" name="description"/>
    </div>
    <div>
        <label>Image</label>
        <input type="file" name="image"/>
    </div>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
