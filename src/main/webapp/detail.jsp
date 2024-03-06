<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- Add necessary imports and styles here -->
<s:form action="details">
<div class="formTable">
  <%--@declare id="clienttype"--%><label for="office" class="required">Office</label>
  <select id="office" name="office" required>
    <option value="">--Select Office--</option>
    <option value="abuja">Abuja</option>
    <option value="apapa">Apapa</option>
    <option value="calabar office">Calabar office</option>
    <option value="head office lagos">Head Office Lagos</option>
    <option value="ikeja">Ikeja</option>
    <option value="kaduna office">Kaduna office</option>
    <option value="kano office">Kano office</option>
    <option value="sysserve ikoyi office">Sysserve Ikoyi office</option>
    <option value="yaba">Yaba</option>
  </select>

  <label for="owner" class="required">Owner</label>
  <select id="owner" name="owner">
    <option value="">--Select Owner--</option>
    <option value="abisoye mayegun">Abisoye Mayegun</option>
    <option value="akeem bakare">Akeem Bakare</option>
    <option value="emmanuel amadiegwu">Emmanuel Amadiegwu</option>
    <option value="faith olaniran">Faith Olaniran</option>
    <option value="ikechukwu ekwe">Ikechukwu Ekwe</option>
    <option value="kazeem balogun">Kazeem Balogun</option>
    <option value="sysdesk admin">Sysdesk Admin</option>
  </select>

  <br>

  <label for="clientType" class="required">Client Type</label>
  <input type="radio" id="individual" name="clientType" value="Individual" checked required>
  <label for="individual">Individual</label>
  <input type="radio" id="company" name="clientType" value="Company" required>
  <label for="company">Company</label>

  <label for="creditType" class="required">Credit Type</label>
  <select id="creditType" name="creditType" required>
    <option value="Credit Client">Credit Client</option>
    <option value="Non Credit Client">Non Credit Client</option>
  </select>

  <label for="date" class="required">Date</label>
  <input type="text" id="date" name="date" value="10/02/2024" readonly required>

  <h3>Client Details</h3>

  <label for="name" class="required">Name</label>
  <select id="name" name="name" required>
    <option value="">--Select Client--</option>
    <!-- Add client options dynamically if needed -->
    <option value="iamOsagie konstructs"> IamOsagie Konstructs</option>
    <option value="stanbic ibtc"> Stanbic Ibtc</option>

  </select>

  <div class="form-group">
    <label for="newContactName" class="required">Contact Name</label>
    <div>
      <input type="text" id="newContactName" name="newContactName" placeholder="Enter New Contact Name">
    </div>
    <div>
      <label for="existingContact" class="required">Existing Contact Name</label>
      <select id="existingContact" name="existingContact" onchange="populateContactDetails()" required>
        <option value="">--Select Contact--</option>
        <option value="segun oshodi"> Segun Oshodi</option>
        <option value="osagie agege"> Osagie Agege</option>
        <!-- Add more contacts as needed -->
      </select>
    </div>
  </div>

  <br>

  <label for="email" class="required">Email</label>
  <input type="email" id="email" name="email" required>

  <label for="phone" class="required">Phone No</label>
  <input type="tel" id="phone" name="phone" required>

  <br>

  <label for="remark">Remark/Reason</label>
  <textarea id="remark" name="remark"></textarea>

  <br>

  <label for="comments" class="required">Comment(s)</label>
  <div id="commentsSection">
    <textarea id="comments" name="comments" class="formTextField" rows="6" cols="50"></textarea>
  </div>
  <button onclick="toggleComments()">Collapse Comment(s)</button>

  <br>

  <button type="submit">Submit</button>
</div>
</s:form>

<script>
  function toggleComments() {
    const commentsSection = document.getElementById("commentsSection");
    const commentsButton = document.querySelector("button[onclick='toggleComments()']");

    if (commentsSection.style.display === "none" || commentsSection.style.display === "") {
      commentsSection.style.display = "block";
      commentsButton.innerHTML = "Collapse Comment(s)";
    } else {
      commentsSection.style.display = "none";
      commentsButton.innerHTML = "Expand Comment(s)";
    }
  }

  function populateContactDetails() {
    const existingContact = document.getElementById('existingContact').value;

    // Populate details based on the selected existing contact
    switch (existingContact) {
      case 'segun oshodi':
        document.getElementById('newContactName').value = 'Segun Oshodi';
        document.getElementById('email').value = 'akeembakarey@gmail.com';
        break;
      case 'osagie agege':
        document.getElementById('newContactName').value = 'Osagie Agege';
        document.getElementById('email').value = 'ossycraig4all@gmail.com';
        document.getElementById('phone').value = '08093125933';
        break;
            // Add more cases for other contacts as needed
      default:
        break;
    }
  }
  function addDetails() {
    // Your existing addDetails function
  }

</script>
