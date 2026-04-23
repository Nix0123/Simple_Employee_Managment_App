# Employee Management App

A full-stack Java EE web application for managing employee records, built with 
Hibernate ORM, Jakarta Servlets, JSP, and Maven. Supports complete CRUD operations 
through a clean web interface with admin authentication.

## 🚀 Features
- Admin Sign Up & Login with session management
- Add, View, Edit, and Delete employee records
- Hibernate ORM for database persistence (no raw JDBC)
- HQL (Hibernate Query Language) for dynamic queries
- DAO pattern for clean separation of data access logic
- JSP-based frontend with form validation

## 🛠️ Tech Stack
| Layer | Technology |
|-------|------------|
| Language | Java |
| Web Framework | Jakarta Servlets + JSP |
| ORM | Hibernate 6 |
| Build Tool | Maven |
| Server | Apache Tomcat |
| Database | MySQL |
| Architecture | MVC + DAO Pattern |

## 📁 Project Structure
EmployeeManagementApp/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/employee/
│       │       ├── dao/
│       │       │   ├── AdminDAO.java
│       │       │   └── EmployeeDAO.java
│       │       ├── model/
│       │       │   ├── Admin.java
│       │       │   └── Employee.java
│       │       ├── servlet/
│       │       │   ├── AddEmployeeServlet.java
│       │       │   ├── DeleteEmployeeServlet.java
│       │       │   ├── EditEmployeeServlet.java
│       │       │   └── ShowEmployeeServlet.java
│       │       └── util/
│       │           └── HibernateUtil.java
│       └── webapp/
│           ├── index.jsp
│           ├── Login.jsp
│           ├── signup.jsp
│           ├── Welcome.jsp
│           ├── addEmployee.jsp
│           ├── showEmployee.jsp
│           ├── deleteEmployee.jsp
│           └── editEmployee.jsp
└── pom.xml

## ⚙️ Setup & Installation

### Prerequisites
- Java 17+
- Apache Tomcat 10+
- MySQL
- Maven

### Steps

1. **Clone the repository**
```bash
git clone https://github.com/your-username/employee-management-app.git
cd employee-management-app
```

2. **Create the database**
```sql
CREATE DATABASE employeedb;
```

3. **Configure Hibernate** — update `hibernate.cfg.xml` with your DB credentials:
```xml
<property name="hibernate.connection.url">
  jdbc:mysql://localhost:3306/employeedb
</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">your_password</property>
```

4. **Build the project**
```bash
mvn clean install
```

5. **Deploy** the generated `.war` file to Tomcat's `webapps/` directory

6. **Access the app** at:http://localhost:8080/EmployeeManagementApp/

## 📋 How It Works

1. Admin registers via the Sign Up page
2. Admin logs in — credentials are validated against the database using HQL
3. From the dashboard, the admin can:
   - **Add Employee** — enter ID, name, department, salary
   - **Show Employees** — view all employees in a table
   - **Delete Employee** — remove by ID and name
   - **Edit Employee** — update salary or department dynamically
4. All data operations go through the DAO layer using Hibernate sessions and transactions

## 🗃️ Key DAO Methods

**AdminDAO**
- `addAdmin(Admin)` — persist new admin
- `validateAdmin(int id, String name)` — login check via HQL
- `getAdminById(int id)` — fetch admin by ID

**EmployeeDAO**
- `addEmployee(Employee)` — save new employee
- `updateEmployee(int id, String name, String field, String newValue)` — dynamic HQL update
- `deleteEmployee(int id, String name)` — HQL delete query
- `getEmployeeById(int id)` — fetch single employee
- `getAllEmployees()` — fetch full employee list

| Page | Description |
|------|-------------|
| Home | Landing page with Sign Up / Login |
| Sign Up | Admin registration form |
| Login | Admin authentication |
| Dashboard | Action menu — Add, Delete, Show, Edit |
| Add Employee | Form to add new employee record |
| Employee List | Table view of all employees |
| Delete Employee | Remove employee by ID and name |
| Edit Employee | Update department or salary |

