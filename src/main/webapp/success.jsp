<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <c:import url="jsp/head.jsp" />
    <c:import url="jsp/style.jsp" />
    <title>Success!</title>
</head>
<body>
<c:import url="jsp/sidebar.jsp" />
<div class="centered">
    <h1>Successful!</h1>
    <a href="index.jsp">Return home</a><br />
    <a href="add.jsp">Add Deck</a><br />
    <a href="viewDecks">View Your Decks</a>
</div>

</body>
</html>
