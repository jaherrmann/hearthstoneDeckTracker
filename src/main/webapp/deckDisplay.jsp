<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Decks</title>
    <c:import url="jsp/head.jsp" />
    <c:import url="jsp/style.jsp" />
</head>
<body>

<c:import url="jsp/sidebar.jsp" />

<div class="w3-main" style="margin-left:300px">

<div style="margin-left:200px">
<c:forEach items="${decks}" var="deck">
    <h2>Deck Name: </h2>
    <h2>${deck.name}</h2>
</c:forEach>


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

    <form action ="/IndieProjectHerrmann/calculateStats">
        <input type="number" value="Enter Wins" name="wins" placeholder="Add Wins"><br />
        <input type="number" value="Enter Losses" name="losses" placeholder="Add Losses"><br />
        <input type="submit" value="Record Stats!">
    </form>

    <form action="areYouSure.jsp">
        <input type="submit" value="Delete Deck">
    </form>

</div>
<c:forEach items="${cards}" var="card">

    <tr>
        <img src="${card}" height="100" width="70" />
    </tr>
</c:forEach>
<br />
<a href="index.jsp">Return Home</a>
</div>
</body>
</html>
