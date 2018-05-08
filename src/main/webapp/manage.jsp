<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="jsp/head.jsp" />
    <c:import url="jsp/style.jsp" />
    <title>Manage Decks</title>
</head>
<body>
    <c:import url="jsp/sidebar.jsp" />
    <div class="centered">
        <form action="/IndieProjectHerrmann/manageDeck" method="GET">
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
    </div>

</body>
</html>





