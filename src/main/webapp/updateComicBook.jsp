<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Comic Book</title>
</head>
<body>
    <form action="comicbook" method="post">
        <input type="hidden" name="id" value="${comicBook.id}"/>
        
        <label for="title">Title: </label>
        <input type="text" id="title" name="title" value="${comicBook.title}" required/><br/>
        
        <label for="issueNumber">Issue Number: </label>
        <input type="text" id="issueNumber" name="issueNumber" value="${comicBook.issueNumber}" required/><br/>
        
        <label for="publicationDate">Publication Date (YYYY-MM-DD): </label>
        <input type="date" id="publicationDate" name="publicationDate" value="${comicBook.publicationDate}" required/><br/>
        
        <label for="comicCondition">comicCondition: </label>
        <input type="text" id="comicCondition" name="comicCondition" value="${comicBook.comicCondition}" required/><br/>
        
        <input type="hidden" name="action" value="update"/>
        <input type="submit" value="Update"/>
    </form>
    <br/>
    <a href="comicbook?action=view">View All Comic Books</a>
</body>
</html>
