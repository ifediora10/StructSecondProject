<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sx" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Welcome Page</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
    <div class="topnav">
        <a href="#" class="active">Home</a>
        <!-- Add more navigation links if needed -->
    </div>

    <h2>Welcome Page</h2>

    <div class="formTable">
        <div class="form-group">
            <div>
                <button onclick="showDetails()">DETAILS</button>
            </div>
            <div>
                <button onclick="showTrips()">TRIPS</button>
            </div>
            <div>
                <s:a action="historyPage"><button>Show History</button></s:a>
            </div>
        </div>

        <div id="detailsSection" style="display: none;">
            <jsp:include page="detail.jsp" />
        </div>

        <div id="tripsSection" style="display: none;">
            <jsp:include page="trip.jsp" />
        </div>

        <div id="historySection" style="display: none;">
            <jsp:include page="listOfTrips.jsp" />
        </div>


    </div>
</div>

<script>
    function showDetails() {
        document.getElementById("detailsSection").style.display = "block";
        document.getElementById("tripsSection").style.display = "none";
        document.getElementById("fileSection").style.display = "none";
        document.getElementById("historySection").style.display = "none";
    }

    function showTrips() {
        document.getElementById("detailsSection").style.display = "none";
        document.getElementById("tripsSection").style.display = "block";
        document.getElementById("fileSection").style.display = "none";
        document.getElementById("historySection").style.display = "none";
    }

    function showHistory() {
        document.getElementById("detailsSection").style.display = "none";
        document.getElementById("tripsSection").style.display = "none";
        document.getElementById("fileSection").style.display = "none";
        document.getElementById("historySection").style.display = "block";
    }
</script>
</body>
</html>
