<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <c:import url="jsp/head.jsp" />
    <c:import url="jsp/style.jsp" />
    <title>Are You Sure?</title>
</head>
<div>
    <body>
    <c:import url="jsp/sidebar.jsp" />
    <div class="w3-main" style="margin-left:300px">
        <div class="centered">
            <h2>Are You Sure You Want To Do That?</h2>
            <form action="/IndieProjectHerrmann/delete">
                <input type="submit" value="Yes, obviously" name="yes"><br />
                <input type="button" value="No, I'm good" onclick="history.back(-1)" />
            </form>

        </div>
    </body>
</div>

</html>

