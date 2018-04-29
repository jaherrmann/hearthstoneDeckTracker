<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2/13/18
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage Decks</title>
</head>
<body>
    <h2>Manage Your Decks</h2>

    <form action="manageDeck" method="GET">
        <h2>Choose A Deck To Manage</h2>
        <select name="deckId">
            <option>Choose</option>
            <c:forEach items="${decks}" var="deck">
                <option name="search" value="<c:out value="${deck.id}"/>">${deck.name}</option>
            </c:forEach>
        </select>
        <br />
        <button type="submit" name="submit" value="submit">Choose Deck</button>
    </form>

    <a href="index.jsp">Return Home</a><br />

</body>
</html>
