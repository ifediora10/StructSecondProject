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


<h2>List of Trips</h2>

<%--<s:if test="tripsList != null && !tripsList.isEmpty()">--%>
    <table border="1">
        <thead>
        <tr>
            <th>#</th>
            <th>Passenger Name</th>
            <th>Pick Up Date</th>
            <th>End Date</th>
            <th>Departure</th>
            <th>Destination</th>
            <th>Vehicle Type</th>
            <th>Service Type</th>
            <th>Total Amount</th>
            <th>Resource</th>
            <th>File</th>
            <th>Edit</th>
            <th>History</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="tripsList" var="trip">
            <tr>
                <td><s:property value="#trip.id" /></td>
                <td><s:property value="#trip.passengerNames" /></td>
                <td><s:property value="#trip.pickUpDate + ' ' + #trip.pickUpTime" /></td>
                <td><s:property value="#trip.endDate + ' ' + #trip.endTime" /></td>
                <td><s:property value="#trip.departure" /></td>
                <td><s:property value="#trip.destination" /></td>
                <td><s:property value="#trip.vehicleType" /></td>
                <td><s:property value="#trip.serviceType" /></td>
                <td><s:property value="#trip.totalAmount" /></td>
                <td id="resourceCell"><s:property value="#trip.resourceAvailability ? #trip.personnelName : ''" /></td>
                <td>
                    <s:url var="downloadUrl" action="downloadFileAction">
                        <s:param name="id"><s:property value="#trip.id"/></s:param>
                    </s:url>
                    <s:a href="%{downloadUrl}">
                        <s:property value="#trip.fileName" />
                    </s:a>

                </td>
                <td>
                    <a href="editTrip?id=<s:property value="#trip.id"/>">
                        <button>Edit</button>
                    </a>
                </td>
                <td>
                    <a href="history?tripId=<s:property value="#trip.id"/>">
                        <button class="actionBtn">History</button>
                    </a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
<%--</s:if>--%>

<%--<s:else>--%>
<%--    <div>No trips found.</div>--%>
<%--</s:else>--%>

<!-- Add your additional HTML, JavaScript, or other content here -->

</body>
</html>
