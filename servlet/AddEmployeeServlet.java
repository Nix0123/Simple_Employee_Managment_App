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

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String salary = request.getParameter("salary");
        String department = request.getParameter("department");

        if (name != null && id != null && salary != null && department != null) {
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(id));
            employee.setName(name);
            employee.setSalary(Double.parseDouble(salary));
            employee.setDepartment(department);

            EmployeeDAO employeeDao = new EmployeeDAO();
            employeeDao.addEmployee(employee);

            request.getSession().setAttribute("message", "Employee added successfully!");
            response.sendRedirect("Welcome.jsp");
        } else {
            response.getWriter().println("<script>alert('Invalid data! Please try again.'); window.location.href='addEmployee.jsp';</script>");
        }
    }
}
