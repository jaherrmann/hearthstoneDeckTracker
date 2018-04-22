<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/4/18
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html><body>

<div class="container-fluid">
    <h2>Search Results: </h2>

    <table border="1px" width="100px">
        <th>Name</th>
        <th>Rarity</th>
        <th>Mana Cost!!!</th>
        <th>Card Set</th>
        <c:forEach items="${cards}" var="card">

            <tr>
                <td>${card.name}</td>
                <td>${card.rarity}</td>
                <td>${card.mana_cost}</td>
                <td>${card.set}</td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>