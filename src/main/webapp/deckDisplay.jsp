<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/29/18
  Time: 12:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Decks</title>
</head>
<body>
<table border="1px" width="100px">
<th>Wins</th>
<th>Losses</th>
<th>Win Percentage</th>

<c:forEach items="${stats}" var="stat">
    <tr>
        <td>${stat.wins}</td>
        <td>${stat.losses}</td>
        <td>${stat.winPercentage}</td>
    </tr>
</c:forEach>
</table>

<c:forEach items="${decks}" var="deck">
    <td>${deck.name}</td>
</c:forEach>

<br />
<br />
<c:forEach items="${cards}" var="card">

    <tr>
        <img src="${card}" height="100" width="70" />
    </tr>
</c:forEach>
<br />
<a href="index.jsp">Return Home</a>
</body>
</html>
