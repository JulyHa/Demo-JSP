<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/3/2023
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h2>Edit</h2>
<for ethod="post">
    id: <input type="text" value="${product.getId()}" name="id">
    name: <input type="text" value="${product.getName()}" name="name">
    amount: <input type="text" value="${product.getAmount()}" name="amount">
    des: <input type="text" value="${product.getDescription()}" name="des">

    <input type="submit" value="gửi"></form>


</body>
</html>
