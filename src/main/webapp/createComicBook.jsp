<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Comic Book</title>
</head>
<body>
    <form action="comicbook" method="post">
        <label for="title">Title: </label>
        <input type="text" id="title" name="title" required/><br/>

        <label for="issueNumber">Issue Number: </label>
        <input type="text" id="issueNumber" name="issueNumber" required/><br/>

        <label for="publicationDate">Publication Date (YYYY-MM-DD): </label>
        <input type="date" id="publicationDate" name="publicationDate" required/><br/>

        <label for="comicCondition">comicCondition: </label>
        <input type="text" id="comicCondition" name="comicCondition" required/><br/>

        <input type="hidden" name="action" value="create"/>
        <input type="submit" value="Submit"/>
    </form>
    <br/>
    <a href="comicbook?action=view">View All Comic Books</a>
</body>
</html>
