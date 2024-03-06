<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Trip History</title>
  <!-- Add your CSS styles or link to an external stylesheet here -->
</head>
<body>

<%@ include file="header.jsp" %>

<h2>Trip History</h2>

<%-- Check if historyList is not empty --%>
<%--<s:if test="historyList != null && !historyList.isEmpty()">--%>
  <table border="1">
    <thead>
    <tr>
      <th>#</th>
      <th>Event Time</th>
      <th>Event Type</th>
      <th>Event User</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="historyList" var="history">
      <tr>
        <td><s:property value="#history.id" /></td>
        <td><s:property value="#history.eventTime" /></td>
        <td><s:property value="#history.eventType" /></td>
        <td><s:property value="#history.eventUser" /></td>
      </tr>
    </s:iterator>
    </tbody>
  </table>
<%--</s:if>--%>

<%-- Display a message if historyList is empty --%>
<%--<s:else>--%>
<%--  <div>No history found for this trip.</div>--%>
<%--</s:else>--%>

<!-- Add your additional HTML, JavaScript, or other content here -->

</body>
</html>
