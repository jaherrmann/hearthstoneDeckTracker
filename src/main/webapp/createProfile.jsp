<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create Profile</title>
    <c:import url="jsp/head.jsp" />
    <c:import url="jsp/style.jsp" />
</head>
<body>
    <c:import url="jsp/sidebar.jsp" />
    <div class="centered">
        <h2>To Create Profile Choose A Username and Enter Password</h2>
        <form action="/IndieProjectHerrmann/addUser">
            <input type="text" value="Enter Username" name="userName"><br />
            <input type="password" value="Enter Password" name="password"><br />
            <input type="submit" value="Create Profile">
        </form>
    </div>
</body>
</html>
