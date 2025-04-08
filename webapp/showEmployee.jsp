<%-- 
    Document   : showEmployee
    Created on : 4 Mar 2025, 12:34:54 am
    Author     : Taranjeet Singh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.employee.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body class="background">
    <div class="container">
        <h2>Employee List</h2>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Department</th>
                <th>Salary</th>
            </tr>
            <%
                List<Employee> employees = (List<Employee>) request.getAttribute("employeeList");
                if (employees != null) {
                    for (Employee emp : employees) {
            %>
            <tr>
                <td><%= emp.getId() %></td>
                <td><%= emp.getName() %></td>
                <td><%= emp.getDepartment() %></td>
                <td><%= emp.getSalary() %></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
        <a href="Welcome.jsp" class="back-button">Back to Home</a>
    </div>
</body>
</html>
