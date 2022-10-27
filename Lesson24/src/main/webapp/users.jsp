<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="users.css"/>
    <title>Title</title>
</head>
<body>
<h1>Users</h1>
<table>
    <tr>
        <td>Login</td>
        <td>Password</td>
    </tr>
    <tbody>
        <% for (User user : (List<User>) request.getAttribute("users")){%>
    <tr>
        <td><%=user.getLogin()%></td>
        <td><%=user.getPassword()%></td>
    </tr>
    <%} %>
    </tbody>
</table>
</body>
</html>
