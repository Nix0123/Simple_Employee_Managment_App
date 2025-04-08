<%-- 
    Document   : addEmployee
    Created on : 4 Mar 2025, 12:28:04 am
    Author     : Taranjeet Singh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body class="background">
    <div class="container">
        <h2>Add Employee</h2>
        <form action="AddEmployeeServlet" method="post">
            <label for="id">Employee ID:</label>
            <input type="text" id="id" name="id" required>

            <label for="name">Employee Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="department">Department:</label>
            <input type="text" id="department" name="department" required>

            <label for="salary">Salary:</label>
            <input type="number" id="salary" name="salary" required>

            <button type="submit">Add Employee</button>
        </form>
        <a href="Welcome.jsp" class="back-button">Back to Home</a>
    </div>
</body>
</html>

