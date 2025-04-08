<%-- 
    Document   : editEmployee
    Created on : 4 Mar 2025, 12:34:16 am
    Author     : Taranjeet Singh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body class="background">
    <div class="container">
        <h2>Edit Employee Details</h2>
        <form action="EditEmployeeServlet" method="post">
            <label for="id">Employee ID:</label>
            <input type="text" id="id" name="id" required>

            <label for="name">Employee Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="field">Select Field to Edit:</label>
            <select id="field" name="field">
                <option value="department">Department</option>
                <option value="salary">Salary</option>
            </select>

            <label for="newValue">New Value:</label>
            <input type="text" id="newValue" name="newValue" required>

            <button type="submit">Update Employee</button>
        </form>
        <a href="Welcome.jsp" class="back-button">Back to Home</a>
    </div>
</body>
</html>

