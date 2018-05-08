<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="jsp/head.jsp" />
    <c:import url="jsp/style.jsp" />
    <title>Admin Authentication</title>
</head>
<body>
<c:import url="jsp/sidebar.jsp" />
<div class="centered">
    <FORM ACTION="j_security_check" METHOD="POST">
        <TABLE>
            <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
            <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
            <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
        </TABLE>
    </FORM>
</div>
</body>
</html>
