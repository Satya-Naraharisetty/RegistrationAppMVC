<%--
  Created by IntelliJ IDEA.
  User: siddu
  Date: 9/29/2024
  Time: 2:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>failed</title>
</head>
<body>
<h1>failed to register</h1>
<% String name = (String) session.getAttribute("UName"); %>
<h2><%= name%>, you have failed to this webapp</h2>
</body>
</html>
