<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Shopping cart</title>
</head>
<body>
<h2>My shopping cart</h2>
<form action="/bookstore/shoppingcart/deletebook" method="post">
<table>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Author</th>
        <th>price</th>
    </tr>
    <c:forEach items="${requestScope.books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <td><input type="checkbox" value="${book.id}" name="id"></td>
        </tr>
    </c:forEach>
</table>
    <input type="submit" value="Usuń zaznaczone">
</form>
<h2>Histogram ${requestScope.histogram}</h2>
<h2>Histogram 2 ${requestScope.histogram2}</h2>
</body>
</html>
