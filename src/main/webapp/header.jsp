<%--
  Created by IntelliJ IDEA.
  User: Blaze
  Date: 26/01/2024
  Time: 08:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="styles.css">
    <title>Header</title>
</head>

<body style="background-color:white;">

<%
    if (session.getAttribute("loggedInUser") == null){
        response.sendRedirect("login.jsp");
    }
%>

<div class="navbar">
    <a href="#home">DASHBOARD</a>
    <a href="#news">JOURNEY MGMT</a>
    <div class="dropdown">
        <button class="dropbtn">FLEET MGMT
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="#">Link 1</a>

            <a href="#">Link 2</a>
<%--            <a href="#">Link 3</a>--%>

            <div class="dropdown2">
                <button class="dropbtn2">Link 3
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content2">
                    <a href="#">Link 1</a>
                    <a href="#">Link 2</a>
                    <a href="#">Link 3</a>
                </div>
            </div>


            <a href="#">Link 4</a>
        </div>
    </div>
    <a href="#home">ASSET/INVENTORY MGMT</a>
    <a href="#news">PROCUREMENT MGMT</a>
</div>

</body>
</html>
