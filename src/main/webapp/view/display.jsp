
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>ListProduct</h1>
<a href="/ProductServlet?action=create"> Thêm 1 sản phẩm</a>
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>Amount</th>
        <th>description</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${listProduct}" var="element">
        <tr>
            <td>${element.id}</td>
            <td>${element.name}</td>
            <td>${element.amount}</td>
            <td>${element.description}</td>
            <td>
                <a href="/ProductServlet?action=edit&id=${element.id}"><button>Edit</button></a>
                <a href="/ProductServlet?action=delete&id=${element.id}"><button>Delete</button></a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
