<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Edit Trip</title>
  <!-- Add your CSS styles or link to an external stylesheet here -->
</head>
<body>

<%@ include file="header.jsp" %>

<h2>Edit Trip</h2>

<s:form action="/updateTrip" id="trips" enctype="multipart/form-data" method="post">
  <s:hidden name="id" value="%{id}" />

  <label for="passengerNames" class="required">Passenger Name(s)</label>
  <s:textfield name="passengerNames" value="%{passengerNames}" />

  <label for="numberOfPassengers" class="required">Number of Passengers</label>
  <s:textfield name="numberOfPassengers" value="%{numberOfPassengers}" />

  <label for="phone" class="required">Phone</label>
  <s:textfield name="phone" value="%{phone}" />

  <label for="email" class="required">Email</label>
  <s:textfield name="email" value="%{email}" />

  <label for="departure" class="required">Departure</label>
  <s:textfield name="departure" value="%{departure}" />

  <label for="destination" class="required">Destination/Possible Stops</label>
  <s:textfield name="destination" value="%{destination}" />

  <label for="pickUpDate" class="required">Pick Up Date</label>
  <s:textfield name="pickUpDate" value="%{pickUpDate}" />

  <label for="pickUpTime">Pick Up Time</label>
  <s:textfield name="pickUpTime" value="%{pickUpTime}" />

  <label for="endDate">End Date</label>
  <s:textfield name="endDate" value="%{endDate}" />

  <label for="endTime">End Time</label>
  <s:textfield name="endTime" value="%{endTime}" />

  <label for="vehicleCategory" class="required">Vehicle Category</label>
  <s:textfield name="vehicleCategory" value="%{vehicleCategory}" />

  <label for="vehicleType" class="required">Vehicle Type</label>
  <s:select name="vehicleType" list="#{'':'--Select Type--', 'pool':'Pool', 'status':'Status', 'thirdParty':'Third Party'}" value="%{vehicleType}" />

  <label for="serviceType" class="required">Service Type</label>
  <s:select name="serviceType" list="#{'pool':'Pool Vehicle', 'rideHailing':'Ride Hailing'}" value="%{serviceType}" />

  <label for="additionalServices">Additional Service(s)</label>
  <s:textfield name="additionalServices" value="%{additionalServices}" />

  <label for="numberOfDays">No Of Day(s)</label>
  <s:textfield name="numberOfDays" value="%{numberOfDays}" oninput="calculateTotalAmount()" />

  <label for="pricePerDay">Price Per Day</label>
  <s:textfield name="pricePerDay" value="%{pricePerDay}" oninput="calculateTotalAmount()" />

  <!-- Add other fields as needed -->

  <label for="additionalInformation" class="required">Additional Information</label>
  <s:textarea name="additionalInformation" value="%{additionalInformation}" />

  <label for="personnelType" class="required">Personnel</label>
  <s:select name="personnelType" list="#{'':'--Select Type--', 'driver':'Driver', 'batteryCharger':'Battery Charger', 'electrician':'Electrician', 'mechanic':'Mechanic', 'painter':'Painter', 'panelBeater':'Panel Beater', 'screenPainter':'Screen Painter'}" value="%{personnelType}" />

  <label for="personnelName" class="required">Personnel Name</label>
  <s:select name="personnelName" list="#{'':'--Select Personnel--', 'deleMomodu':'Dele Momodu', 'jideAdeyemi':'Jide Adeyemi', 'kayodeAjibade':'Kayode Ajibade'}" value="%{personnelName}" />

  <label for="vehicle" class="required">Vehicle</label>
  <s:select name="vehicle" list="#{'':'--Select Vehicle--'}" />

  <label for="resourceAvailability">Is Resource Available</label>
  <s:checkbox name="resourceAvailability" />

  <label for="totalAmount" class="required">Total Amount</label>
  <s:textfield name="totalAmount" value="%{totalAmount}" readonly="true"/>

  <s:file name="fileInput" label="Select File" />
  <s:textfield name="fileName" label="File Name"/>

  <s:submit value="Update" />
</s:form>

<!-- Add your additional HTML, JavaScript, or other content here -->

</body>
</html>
