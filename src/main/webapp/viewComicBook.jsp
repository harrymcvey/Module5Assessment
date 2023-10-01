<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Comic Books</title>
</head>
<body>
    <h2>Comic Books</h2>
    <table border="1">
        <thead>
        <tr>
            <th>Title</th>
            <th>Issue Number</th>
            <th>Publication Date</th>
            <th>comicCondition</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="comicBook" items="${comicBooks}">
            <tr>
                <td>${comicBook.title}</td>
                <td>${comicBook.issueNumber}</td>
                <td>${comicBook.publicationDate}</td>
                <td>${comicBook.comicCondition}</td>
                <td>
                    <a href="comicbook?action=edit&id=${comicBook.id}">Edit</a> |
                    <a href="comicbook?action=delete&id=${comicBook.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
    <a href="createComicBook.jsp">Add Another Comic Book</a>
</body>
</html>
