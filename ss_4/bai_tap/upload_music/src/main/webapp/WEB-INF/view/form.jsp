<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form method="post" action="save" novalidate="novalidate" enctype="multipart/form-data">
    <input type="hidden" name="id" value="0">
    <div>
        Name: <input type="text" name="name">
    </div>

    <div>
        artist: <input type="text" name="artist">
    </div>

    <div>
        genre: <input type="text" name="genre">
    </div>
    <div>
        image: <input type="file" name="image">
    </div>

    <button>Create</button>
</form>
</body>
</html>
