<%-- 
    Document   : index
    Created on : 4 Mar 2025, 12:25:29 am
    Author     : Taranjeet Singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Arial', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(135deg, #74EBD5, #9FACE6);
        }

        .container {
            text-align: center;
            background: rgba(255, 255, 255, 0.2);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            backdrop-filter: blur(10px);
        }

        h1 {
            color: #fff;
            margin-bottom: 20px;
        }

        .btn {
            display: inline-block;
            padding: 10px 20px;
            font-size: 18px;
            font-weight: bold;
            text-decoration: none;
            border-radius: 5px;
            transition: background 0.3s ease;
            cursor: pointer;
        }

        .signup {
            background: #FF6B6B;
            color: #fff;
        }

        .signup:hover {
            background: #FF8E8E;
        }

        .login {
            background: #1E90FF;
            color: #fff;
        }

        .login:hover {
            background: #63B3FF;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Our Website</h1>
        <p>Join us or log in to continue</p>
        <br>
        <a href="signup.jsp" class="signup">Sign Up</a><br><br>
        <a href="Login.jsp" class="login">Login</a>
        
    </div>
</body>
</html>