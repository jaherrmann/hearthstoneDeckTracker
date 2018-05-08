<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="jsp/head.jsp" />
    <c:import url="jsp/style.jsp" />
    <title>Add a Deck!</title>
</head>
<body>
<c:import url="jsp/sidebar.jsp" />
    <div class="topHeavy">
        <H1>Add A Deck!</H1>
        <form action="/IndieProjectHerrmann/addDeck">
            <input type="text" name="card1">
            <input type="text" name="card2">
            <input type="text" name="card3">
            <input type="text" name="card4">
            <input type="text" name="card5">
            <input type="text" name="card6">
            <input type="text" name="card7">
            <input type="text" name="card8">
            <input type="text" name="card9">
            <input type="text" name="card10">
            <input type="text" name="card11">
            <input type="text" name="card12">
            <input type="text" name="card13">
            <input type="text" name="card14">
            <input type="text" name="card15">
            <input type="text" name="card16">
            <input type="text" name="card17">
            <input type="text" name="card18">
            <input type="text" name="card19">
            <input type="text" name="card20">
            <input type="text" name="card21">
            <input type="text" name="card22">
            <input type="text" name="card23">
            <input type="text" name="card24">
            <input type="text" name="card25">
            <input type="text" name="card26">
            <input type="text" name="card27">
            <input type="text" name="card28">
            <input type="text" name="card29">
            <input type="text" name="card30">
            <input type="text" name="name" value="Name of Deck">
            <input type="submit" value="submit deck">
        </form>
        </div>
    <br />
    <c:import url="jsp/logout.jsp" />
</body>
</html>

