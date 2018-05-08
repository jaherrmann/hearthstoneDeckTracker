<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="jsp/head.jsp" />
    <c:import url="jsp/style.jsp" />
    <title>Manage Users</title>
</head>
<body>
<c:import url="jsp/sidebar.jsp" />
<div class="centered">
    <form action="/IndieProjectHerrmann/updateUser" method="GET">
        <h2>Choose a User To View</h2>
        <select name="userId">
            <option>Choose</option>
            <c:forEach items="${users}" var="user">
                <option name="search" value="<c:out value="${user.id}"/>">${user.user_name}</option>
            </c:forEach>
        </select>
        <br />
        <button type="submit" name="submit" value="submit">Choose User</button>
    </form>
    <a href="index.jsp">Return Home</a><br />
</div>

</body>
</html>





