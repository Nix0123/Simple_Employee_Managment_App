<%@ page session="true" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Page</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(135deg, #74EBD5, #9FACE6);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            background: #fff;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
        }
        h1 {
            color: #333;
        }
        .btn {
            display: inline-block;
            margin: 10px;
            padding: 15px 25px;
            font-size: 18px;
            text-decoration: none;
            color: #fff;
            border-radius: 5px;
            transition: 0.3s;
        }
        .add-btn { background: #28a745; }
        .remove-btn { background: #dc3545; }
        .show-btn { background: #007bff; }
        .update-btn { background: #ffc107; color: #333; }
        .btn:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Welcome, <%= session.getAttribute("username") %>!</h1>
    <p>Choose an action below:</p>
    
    <a href="addEmployee.jsp" class="btn add-btn">Add Employee</a>
    <a href="deleteEmployee.jsp" class="btn remove-btn">Remove Employee</a>
    <a href="showEmployee.jsp" class="btn show-btn">Show List of Employees</a>
    <a href="editEmployee.jsp" class="btn update-btn">Update Employee Details</a>
    
    <br><br>
    <form action="index.jsp" method="post">
        <button type="submit" class="btn" style="background: #6c757d;">Logout</button>
    </form>
</div>

</body>
</html>
