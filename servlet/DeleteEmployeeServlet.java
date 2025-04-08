/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employee.servlet;

import com.employee.dao.EmployeeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        if (id != null && name != null) {
            EmployeeDAO employeeDAO = new EmployeeDAO();
            boolean deleted = employeeDAO.deleteEmployee(Integer.parseInt(id), name);

            if (deleted) {
                request.getSession().setAttribute("message", "Employee deleted successfully!");
            } else {
                response.getWriter().println("<script>alert('Employee not found!'); window.location.href='deleteEmployee.jsp';</script>");
            }
            response.sendRedirect("Welcome.jsp");
        } else {
            response.getWriter().println("<script>alert('Invalid data! Please try again.'); window.location.href='deleteEmployee.jsp';</script>");
        }
    }
}
