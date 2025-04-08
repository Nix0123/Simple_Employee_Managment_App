/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employee.servlet;

import com.employee.dao.AdminDAO;
import com.employee.model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        AdminDAO adminDAO = new AdminDAO();  // Create an instance of AdminDAO
        boolean isValid = adminDAO.validateAdmin(id, name);  // Call the method on the object

        if (isValid) {
            request.getSession().setAttribute("adminName", name);
            response.sendRedirect("Welcome.jsp");
        } else {
            response.getWriter().println("<script>alert('Incorrect name or id');window.location='login.jsp';</script>");
        }
    }
}
