/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employee.servlet;


import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ShowEmployeeServlet")
public class ShowEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        EmployeeDAO employeeDao = new EmployeeDAO();
        List<Employee> employeeList = employeeDao.getAllEmployees();

        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("showEmployee.jsp").forward(request, response);
    }
}
