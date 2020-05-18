<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Books list</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Author</th>
        <th>price</th>
        <%--<th>Add post</th>--%>
        <th>Add get</th>
    </tr>
    <form method="post" action="shoppingcart/addbook">
    <c:forEach items="${requestScope.books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <%--<td>
                <form action="shoppingcart/addbook" method="post">
                    <input type="hidden" value="${book.id}" name="id"/>
                    <input type="submit" value="Do koszyka"/>
                </form>
            </td>--%>
            <td><a href="shoppingcart/addbook?id=${book.id}">Do Koszyka</a></td>
            <td><input type="checkbox" name="id" value="${book.id}"></td>
        </tr>
    </c:forEach>
        <input type="submit" value="Dodaj do zamówienia">
    </form>
</table>
Hello World from books list
</body>
</html>
