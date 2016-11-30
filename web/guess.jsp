<%--
  Created by IntelliJ IDEA.
  User: ZhenYu
  Date: 30/11/2016
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>guess</title>
</head>
<%
    String nric = request.getParameter("nric");
    String email = request.getParameter("email");
    if (nric != null && email != null) {
        session.setAttribute("nric", nric);
        session.setAttribute("email", email);
    } else {
        nric = (String)session.getAttribute("nric");
        email = (String)session.getAttribute("email");
    }
%>
<body>
<form action="/controller">
    Your NRIC is <%= nric %> <br>
    Your email address is <%= email %>
    <input type="text" name="guess" placeholder="Pick your lucky number" />
    <input type="submit" />
</form>
</body>
</html>
