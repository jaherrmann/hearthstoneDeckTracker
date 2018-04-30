<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/29/18
  Time: 12:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Decks</title>
</head>
<body>

<c:forEach items="${decks}" var="deck">
    <td>${deck.name}</td>
    <%--<td>${deck.card1}</td>--%>
    <%--<td>${deck.card2}</td>--%>
    <%--<td>${deck.card3}</td>--%>
    <%--<td>${deck.card4}</td>--%>
    <%--<td>${deck.card5}</td>--%>
    <%--<td>${deck.card6}</td>--%>
    <%--<td>${deck.card7}</td>--%>
    <%--<td>${deck.card8}</td>--%>
    <%--<td>${deck.card9}</td>--%>
    <%--<td>${deck.card10}</td>--%>
    <%--<td>${deck.card11}</td>--%>
    <%--<td>${deck.card12}</td>--%>
    <%--<td>${deck.card13}</td>--%>
    <%--<td>${deck.card14}</td>--%>
    <%--<td>${deck.card15}</td>--%>
    <%--<td>${deck.card16}</td>--%>
    <%--<td>${deck.card17}</td>--%>
    <%--<td>${deck.card18}</td>--%>
    <%--<td>${deck.card19}</td>--%>
    <%--<td>${deck.card20}</td>--%>
    <%--<td>${deck.card21}</td>--%>
    <%--<td>${deck.card22}</td>--%>
    <%--<td>${deck.card23}</td>--%>
    <%--<td>${deck.card24}</td>--%>
    <%--<td>${deck.card25}</td>--%>
    <%--<td>${deck.card26}</td>--%>
    <%--<td>${deck.card27}</td>--%>
    <%--<td>${deck.card28}</td>--%>
    <%--<td>${deck.card29}</td>--%>
    <%--<td>${deck.card30}</td>--%>
</c:forEach>

<br />

<c:forEach items="${cards}" var="card">

    <tr>
        <img src="${card}" height="100" width="70" />
    </tr>
</c:forEach>

</body>
</html>
