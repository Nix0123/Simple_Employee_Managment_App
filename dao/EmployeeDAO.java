package com.employee.dao;

import com.employee.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.employee.util.HibernateUtil;

import java.util.List;

public class EmployeeDAO {

    /**
     * Save an employee to the database.
     * @param employee Employee object to save
     */
    public void addEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update employee details in the database.
     * @param id Employee ID
     * @param field Field to update (e.g., "salary" or "department")
     * @param newValue New value for the field
     * @return true if update is successful, false otherwise
     */
    public boolean updateEmployee(int id, String field, String newValue) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                if ("salary".equalsIgnoreCase(field)) {
                    employee.setSalary(Double.parseDouble(newValue));
                } else if ("department".equalsIgnoreCase(field)) {
                    employee.setDepartment(newValue);
                } else {
                    return false;
                }
                session.update(employee);
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Delete an employee from the database.
     * @param id Employee ID
     * @param name Employee Name
     * @return true if deletion is successful, false otherwise
     */
    public boolean deleteEmployee(int id, String name) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Employee WHERE id = :id AND name = :name");
            query.setParameter("id", id);
            query.setParameter("name", name);
            int result = query.executeUpdate();
            transaction.commit();
            return result > 0;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Get all employees from the database.
     * @return List of Employee objects
     */
    public List<Employee> getAllEmployees() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Employee", Employee.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Validate employee login.
     * @param id Employee ID
     * @param name Employee Name
     * @return true if employee exists, false otherwise
     */
    public boolean validateEmployee(int id, String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Employee> query = session.createQuery("FROM Employee WHERE id = :id AND name = :name", Employee.class);
            query.setParameter("id", id);
            query.setParameter("name", name);
            Employee employee = query.uniqueResult();
            return employee != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
