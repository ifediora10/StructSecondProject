<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Document Page</title>
    <style>

        .title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }
        /*select, input {*/
        /*    width: 80%;*/
        /*    padding: 10px;*/
        /*    margin-bottom: 10px;*/
        /*    box-sizing: border-box;*/
        /*}*/
        button {
            padding: 10px 15px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button.cancel {
            background-color: #d9534f;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="title">Attach File</div>

    <s:form action="uploadFile" method="post" enctype="multipart/form-data" onsubmit="return validateFileSize()">
        <div class="form-group">
            <label for="fileType">Type</label>
            <select id="fileType" name="fileType">
                <option value="pdf">PDF</option>
                <option value="doc">DOC</option>
                <option value="docx">DOCX</option>
                <!-- Add more file type options if needed -->
            </select>
        </div>

        <div class="form-group">
            <label for="fileInput">Choose File</label>
            <input type="file" id="fileInput" name="fileInput" accept=".pdf,.doc,.docx" required>
        </div>

        <div class="form-group">
            <button type="submit">Upload</button>
            <button type="button" class="cancel" onclick="cancelUpload()">Cancel</button>
        </div>

        <div class="form-group">
            <p>Note: Maximum file size is 25MB</p>
        </div>
    </s:form>
</div>

<script>
    function validateFileSize() {
        var fileSize = document.getElementById("fileInput").files[0].size; // in bytes
        var maxSize = 25 * 1024 * 1024; // 25MB

        if (fileSize > maxSize) {
            alert("File size exceeds the maximum allowed (25MB). Please choose a smaller file.");
            return false;
        }

        return true;
    }

    function cancelUpload() {
        if (confirm("Are you sure you want to cancel the upload?")) {
            // Add cancel logic here if needed
            console.log("Upload canceled");
            window.location.href = "welcome.jsp"; // Redirect to welcome page or another appropriate page
        }
    }
</script>

</body>
</html>
