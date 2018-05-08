<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <c:import url="jsp/head.jsp" />
    <c:import url="jsp/style.jsp" />
    <title>Sign In to View Decks</title>
</head>
<div>
<body>
<c:import url="jsp/sidebar.jsp" />
<div class="w3-main" style="margin-left:300px">
    <div class="centered">
        <h2>Enter Credentials</h2>
        <form action="/IndieProjectHerrmann/signIn">
            <input type="text" value="Enter Username" name="userName"><br />
            <input type="password" value="Enter Password" name="password"><br />
            <input type="submit" value="Log In">
        </form>
    </div>
    </body>
</div>

</html>

