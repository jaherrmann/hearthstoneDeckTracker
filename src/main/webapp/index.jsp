<%--
<%@include file="head.jsp"%>
--%>
<html>
<head>
    <title>Hearthstone Deck Tracker</title>
</head>
<body>
    <h2>Hello World! This is my hearthstone project</h2>
    <a href="add.jsp">Add Deck</a><br />
    <a href="record.jsp">Record W/L</a><br />
    <a href="find.jsp">Find Decks</a><br />
    <a href="profile.jsp">Profile</a>


<h2>User Display Exercise - Week 1</h2>
<!--<a href = "searchUser">Search</a>-->
<form action="searchDeck" class="form-inline">
    <input tpye="text" name="searchTerm" value=""><br />
    <input type="radio" name="searchType" value="last_name">Last Name <br />
    <input type="submit" name="submit" value="submit">
</form>

</body>
</html>

