<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #74EBD5, #9FACE6);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            background: rgba(255, 255, 255, 0.2);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            backdrop-filter: blur(10px);
            width: 400px;
        }

        h2 {
            text-align: center;
            color: #fff;
        }

        label {
            color: #fff;
            font-weight: bold;
        }

        input[type="text"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            border: none;
        }

        input[type="submit"] {
            background-color: #1E90FF;
            color: #fff;
            font-weight: bold;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #63B3FF;
        }

        .error {
            color: #FF6B6B;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Admin Login</h2>
        <form method="post" action="Login.jsp">
            <label for="id">Admin ID:</label>
            <input type="text" name="id" required>

            <label for="name">Admin Name:</label>
            <input type="text" name="name" required>

            <input type="submit" value="Login">
        </form>

        <%
            // Database connection and authentication logic
            String id = request.getParameter("id");
            String name = request.getParameter("name");

            if (id != null && name != null) {
                Connection conn = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;

                try {
                    // Load MySQL JDBC driver
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    
                    // Connect to the database
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");

                    // Prepare SQL query to check the employee
                    String sql = "SELECT * FROM admin_data WHERE id = ? AND name = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, id);
                    stmt.setString(2, name);
                    rs = stmt.executeQuery();

                    // Check if employee exists
                    if (rs.next()) {
                        response.sendRedirect("Welcome.jsp");
                    } else {
                        out.println("<p class='error'>Invalid ID or Name. Please try again.</p>");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<p class='error'>Error: " + e.getMessage() + "</p>");
                } finally {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                }
            }
        %>
    </div>
</body>
</html>
