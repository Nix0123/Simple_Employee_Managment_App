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

@WebServlet("/EditEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String field = request.getParameter("field");
        String newValue = request.getParameter("newValue");

        if (id != null && name != null && field != null && newValue != null) {
            EmployeeDAO employeeDao = new EmployeeDAO();
            boolean updated = employeeDao.updateEmployee(Integer.parseInt(id), field, newValue);


            if (updated) {
                request.getSession().setAttribute("message", "Employee details updated successfully!");
                response.sendRedirect("Welcome.jsp");
            } else {
                response.getWriter().println("<script>alert('Employee not found or invalid data!'); window.location.href='editEmployee.jsp';</script>");
            }
        } else {
            response.getWriter().println("<script>alert('Invalid data! Please try again.'); window.location.href='editEmployee.jsp';</script>");
        }
    }
}



