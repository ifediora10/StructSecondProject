<%--<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Blaze
  Date: 05/02/2024
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Request</title>

    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>



    <script>
        $(function() {


            // Set current date
            var currentDate = new Date();
            var formattedDate = currentDate.toISOString().slice(0, 10);
            $("#dateField").val(formattedDate);
        });
        $(function() {
            // Set current time
            var currentTime = new Date();
            var formattedTime = currentTime.toLocaleTimeString('en-US', { hour12: false });
            $("#timeField").val(formattedTime);
        });
        // $(document).ready(function() {
        //     // When the dropdown label is clicked
        //     $('#dropdownLabel').click(function() {
        //         // Toggle the visibility of the section
        //         $('#revealingSection').slideToggle();
        //
        //         // Toggle a class to rotate the arrow icon
        //         $('#dropdownIcon').toggleClass('rotate');
        //     });
        // });
        $(document).ready(function() {
            // When the dropdown label is clicked
            $('#dropdownLabel').click(function() {
                // Toggle the visibility of the section
                $('#revealingSection').slideToggle();

                // Toggle a class on the revealing section
                $('#revealingSection').toggleClass('revealingSectionVisible');
            });
        });
    </script>

</head>
<body>
<%@ include file="header.jsp" %>


<s:form action="details" id="details">

    <label for="office">Office:</label>
    <select id="office" name="office" onchange="loadDrivers()">
        <option value="">-- Select Office --</option>
        <option value="lagos">Lagos</option>
        <option value="abuja">Abuja</option>
        <option value="kano">Kano</option>
        <option value="jos">Jos</option>
        <option value="benin">Benin</option>
    </select>

    <label for="client">Client:</label>
    <select id="client" name="client" onchange="loadDrivers()">
        <option disabled selected value="">-- Select Client --</option>
        <option value="GTB">GTB</option>
        <option value="UBA">UBA</option>
        <option value="union">Union</option>
        <option value="KPMG">KPMG</option>
        <option value="fidelity">Fidelity</option>
    </select>
    <br/>

    <label for="vehicle">Vehicle:</label>
    <select id="vehicle" name="vehicle" onchange="loadDrivers()">
        <option value="">-- Select Vehicle --</option>
        <option value="SUV">SUV</option>
        <option value="saloon">Saloon</option>
        <option value="bus">Bus</option>
        <option value="truck">Truck</option>
        <option value="van">Van</option>
    </select>

    <label for="vehicleName">
        <select id="vehicleName" name="vehicleName">
            <option value="">-- Select --</option>
        </select>
    </label>

<%--    <label for="millage">Millage/Date:--%>
<%--    <textarea id="millage" name="millage" style="height: 16px; width: 57px;"></textarea>--%>
<%--    </label>--%>
    <label for="millage">Millage:</label>
    <input type="text" id="millage" name="millage">


    <label for="dateField">date:</label>
    <input type="date" id="dateField" name="date">

    <label for="timeField">Select Time:</label>
    <input id="timeField" name="yourTimeFieldName" type="time" />
    <br/>

    <label for="drivers">Driver:
    <select id="drivers" name="driver">
        <option value="">-- Select Drivers --</option>
    </select>
    </label>

<%--    <label for="location">Location:--%>
<%--        <textarea id="location" name="location" style="height: 16px; width: 57px;"></textarea>--%>
<%--    </label>--%>
            <label for="location">Location:</label>
            <input type="text" id="location" name="location">
<%--    <s:textfield value="Location" name="firstName"/>--%>



<br/>
    <label for="faultType">Fault Type:</label>
    <select id="faultType" name="faultType">
        <option value="">-- Select Fault --</option>
        <option value="accident">Accident</option>
        <option value="breakdown">Breakdown</option>
        <option value="correctives">Correctives</option>
        <option value="routineService">Routine Service</option>
        <option value="inspection">Inspection</option>
    </select>
<br/>
    <label for="complaint">Comments:</label>
    <textarea id="complaint" name="complaint" rows="4" cols="50"></textarea>
<br/>
    <label for="status">Status:</label>
    <select id="status" name="status">
        <option value="">Submitted</option>
    </select>
 <br/>

    <!-- Dropdown button -->
<%--    <button type="button" id="dropdownButton">Comments</button>--%>

    <label id="dropdownLabel">Comments<span id="dropdownIcon">▶</span></label>

    <div id="revealingSection">

        <label for="comment">Comments:</label>
        <textarea id="comment" name="comment" rows="4" cols="50"></textarea>
<br/>
        <label for="assign">Assign:</label>
        <select id="assign" name="assign">
            <option value="">-- Select --</option>
            <option value="accident">Victory</option>
            <option value="breakdown">Charles</option>
            <option value="correctives">Emma</option>
            <option value="routineService">Paul</option>
            <option value="inspection">Samuel</option>
        </select>
<br/>
        <label for="notify">Notify:</label>
        <select id="notify" name="notify">
            <option value="">-- Select --</option>
            <option value="accident">Victory</option>
            <option value="breakdown">Charles</option>
            <option value="correctives">Emma</option>
            <option value="routineService">Paul</option>
            <option value="inspection">Samuel</option>
        </select>
<%--        <label for="inputField">Input Field:</label>--%>
<%--        <input type="text" id="inputField" name="inputField">--%>
    </div>


</s:form>







<%--<form id="driversForm">--%>
<%--    <label for="drivers">Drivers:</label>--%>
<%--    <select id="drivers" name="drivers">--%>
<%--        <option value="">-- Select Drivers --</option>--%>
<%--    </select>--%>
<%--</form>--%>

<script type="text/javascript">
    function loadDrivers() {
        var officeSelect = document.getElementById("office");
        var driversSelect = document.getElementById("drivers");
        var vehicleSelect = document.getElementById("vehicle");
        var vehicleNameSelect = document.getElementById("vehicleName")

        // Clear existing options
        driversSelect.innerHTML = '<option value="">-- Select Drivers --</option>';
        vehicleNameSelect.innerHTML = '<option value="">-- Select --</option>';

        // Get the selected office value
        var officeValue = officeSelect.value;
        var vehicleValue = vehicleSelect.value;

        // Implement logic to load driver options based on the selected 'office' value
        if (officeValue === "lagos") {
            addOption(driversSelect, "samuel", "samuel");
            addOption(driversSelect, "victor", "victor");
            addOption(driversSelect, "paul", "paul");
            addOption(driversSelect, "godson", "godson");
        } else if (officeValue === "abuja") {
            addOption(driversSelect, "gerald", "gerald");
            addOption(driversSelect, "emma", "emma");
            addOption(driversSelect, "francais", "francais");
            addOption(driversSelect, "micheal", "micheal");
        } else if (officeValue === "kano") {
            addOption(driversSelect, "charles", "charles");
            addOption(driversSelect, "emma", "emma");
            addOption(driversSelect, "uche", "uche");
            addOption(driversSelect, "wisdom", "wisdom");
        // Add more conditions as needed
        }else if (officeValue === "jos") {
            addOption(driversSelect, "godwin", "godwin");
            addOption(driversSelect, "precious", "precious");
            addOption(driversSelect, "bisi", "bisi");
            addOption(driversSelect, "zak", "zak");
        }

        if (vehicleValue === "SUV"){
            addOption(vehicleNameSelect, "acuraMDX", "Acura MDX")
            addOption(vehicleNameSelect, "toyotaVenxa", "Toyota Venza")
            addOption(vehicleNameSelect, "audiQ3", "Audi Q3")
        }else if (vehicleValue === "saloon"){
            addOption(vehicleNameSelect, "toyotaCamry", "Toyota Camry")
            addOption(vehicleNameSelect, "toyotaAvalon","toyotaAvalon")
            addOption(vehicleNameSelect, "BMWM5", "BMW M5")
        }else if (vehicleValue === "bus"){
            addOption(vehicleNameSelect, "miniBus", "mini Bus")
            addOption(vehicleNameSelect, "s36DD", "S36 Double Decker")
        }else if (vehicleValue === "truck"){
            addOption(vehicleNameSelect, "toyotaTacoma","Toyota Tacoma")
            addOption(vehicleNameSelect, "toyotaHilux", "Toyota Hilux")
            addOption(vehicleNameSelect, "fordRanger", "Ford Ranger")
        }else if (vehicleValue === "van"){
            addOption(vehicleNameSelect, "miniPU", "Mini Pickup")
            addOption(vehicleNameSelect, "sprinter", "Mercedes Sprinter")
        }

    }

    function addOption(selectElement, value, text) {
        var option = document.createElement("option");
        option.value = value;
        option.text = text;
        selectElement.add(option);
    }
</script>



</body>
</html>
