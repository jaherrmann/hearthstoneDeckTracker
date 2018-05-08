<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="jsp/head.jsp" />
    <c:import url="jsp/style.jsp" />
    <title>ADMIN</title>
</head>
<c:import url="jsp/sidebar.jsp" />
<body>
    <div class="centered">
        <h2>Hello, Hearthstone Master; how are you today?</h2>
        <form action="/IndieProjectHerrmann/viewAllUsers">
            <input type="submit" value="View Users"><br />
        </form>
        <form action="/IndieProjectHerrmann/viewDecks">
            <input type="submit" value="View Decks"><br />
        </form>
    </div>
</body>
</html>
