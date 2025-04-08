package com.employee.dao;

import com.employee.model.Admin;
import com.employee.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class AdminDAO {

    // Add Admin (Sign Up)
    public void addAdmin(Admin admin) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(admin);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    
    // Save admin details to the database
    public static void saveAdmin(Admin admin) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(admin);   // Save the admin object
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Check Admin Login
    public boolean validateAdmin(int id, String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Admin> query = session.createQuery("from Admin where id = :id and name = :name", Admin.class);
            query.setParameter("id", id);
            query.setParameter("name", name);
            Admin admin = query.uniqueResult();
            return admin != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get Admin by ID
    public Admin getAdminById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Admin.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

