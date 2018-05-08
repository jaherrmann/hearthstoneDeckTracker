<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Update User</title>
    <c:import url="jsp/head.jsp" />
    <c:import url="jsp/style.jsp" />
</head>
<body>

<c:import url="jsp/sidebar.jsp" />

<div class="w3-main" style="margin-left:300px">

    <div style="margin-left:200px">
        <c:forEach items="${user}" var="user">
            <h2>User Name: </h2>
            <h2>${user.user_name}</h2>
        </c:forEach>

        <form action ="/IndieProjectHerrmann/commitUpdateUser">
            <input type="text" value="Enter New username" name="newUserName" placeholder="New UserName"><br />
            <input type="submit" value="Update User">
        </form>

        <%--<form action="areYouSure.jsp">--%>
            <%--<input type="submit" value="Delete User">--%>
        <%--</form>--%>

    </div>