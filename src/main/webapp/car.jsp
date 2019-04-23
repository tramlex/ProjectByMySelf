<%--
  Created by IntelliJ IDEA.
  User: ATimofeev
  Date: 23.04.2019
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Your Car!</h2>

<form action="/Car" method="get">
    <p><input placeholder="model" name="model"></p>
    <p><input placeholder="horsepower" name="horsepower"></p>
    <p><input placeholder="ownerId" name="ownerId"></p>
    <p><input type="submit" value="add"></p>
</form>
<form action="address.jsp" method="get">
    <p><input type="submit" value="submit"></p>
</form>
</body>
</html>
