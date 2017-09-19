<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username=(String)request.getAttribute("username");
%>
    username : <%=username%>
</body>
</html>
