<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>File Upload</title>
</head>
<body>

<h2>File Upload</h2>

<form action="<s:url action='fileUploadAction'/>" method="post" enctype="multipart/form-data">
  <label for="fileInput">Choose File:</label>
  <input type="file" name="fileInput" id="fileInput" required/><br/>

  <label for="fileName">File Name:</label>
  <input type="text" name="fileName" id="fileName" required/><br/>

  <input type="submit" value="Upload"/>
</form>

<hr/>

<h2>File List</h2>

<s:if test="${not empty fileList}">
  <table border="1">
    <tr>
      <th>File ID</th>
      <th>File Name</th>
      <th>Actions</th>
    </tr>
    <s:iterator var="file">
      <tr>
        <td>${file.id}</td>
        <td>${file.fileName}</td>
        <td>
          <a href="<s:url action='downloadFileAction' namespace='/'/>">
            <s:param name="id" value="${file.id}"/></a>
        </td>
      </tr>
    </s:iterator>
  </table>
</s:if>

</body>
</html>