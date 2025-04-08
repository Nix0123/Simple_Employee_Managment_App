/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employee.servlet;

import com.employee.dao.AdminDAO;
import com.employee.model.Admin;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");

            Admin admin = new Admin();
            admin.setId(id);
            admin.setName(name);

            AdminDAO.saveAdmin(admin);

            // Show success alert and redirect to login page
            response.getWriter().println("<script>alert('Sign up successful! Please log in.'); window.location='login.jsp';</script>");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<script>alert('Error during sign up. Please try again.'); window.location='signup.jsp';</script>");
        }
    }
}
