<%--
  Created by IntelliJ IDEA.
  User: ZhenYu
  Date: 30/11/2016
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
Congratulation <%= session.getAttribute("nric") %> <%= request.getParameter("guess") %> is the right number! <a href="guess.jsp">Back to Home </a>
</body>
</html>
