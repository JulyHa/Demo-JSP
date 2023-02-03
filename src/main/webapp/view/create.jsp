<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/3/2023
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<form action="/ProductServlet" method="post">
    Id: <input type="text" name="id"> <br>
    Name: <input type="text" name="name"> <br>
    Amount: <input type="text" name="amount"> <br>
    Des: <input type="text" name="des"> <br>
    <input type="submit" value="Send">
</form>

</body>
</html>
