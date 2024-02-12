<%--
  Created by IntelliJ IDEA.
  User: Blaze
  Date: 07/02/2024
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LIST OF VEHICLE MAINTENANCE REQUESTS</title>
</head>
<body>

<div>

  <s:form action="newRequest" class="filterPanel">
    <s:textfield name="productName" label="Product Name" class="formTextField"/>
    <s:textfield name="productCategory" label="Product Category" class="formTextField"/>
    <sx:datetimepicker name="createdDate" label="Create Date" displayFormat="dd-MMM-yyyy"/>
    <s:submit value="Search Product" class="actionBtn"/>
  </s:form>

</div>

</body>
</html>
