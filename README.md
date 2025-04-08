# PLEASE READ READ.MD IN CODE FORMATE FOR BETTER UNDERSTANDING

This project was for a learning concept which implemented "Enterprise Java Application" with Maven, Hibernate, Servlet and DAO files. 

Following is the description of the project, along with necessary info on deploying it:

IMPLEMENTED ON: Apache Netbeans IDE 24.
SERVER USED: Tomcat-10.
Database ON: XAMPP LocatHost MySQL.

# Requirments before implementation: 

1. Create a database named "employeeDB" contaning a table named "employees" with the following schema:-
    -id Primary	int(11)	AUTO_INCREMENT	
    -name	varchar(50)				
    -department	varchar(50)		
    -salary	int(10)

2. Download and install Apcahe Netbeans IDE 24.
3. Download and implement Tomcat-10 Server.

# Steps for implementation:-

If Hibernate isn't available, you will need to download the following JAR files and add them manually:
•	hibernate-core-x.x.x.Final.jar
•	hibernate-commons-annotations-x.x.x.Final.jar
•	hibernate-entitymanager-x.x.x.Final.jar
•	javax.persistence-api-x.x.x.jar
•	log4j.jar (for logging)
•	slf4j-api.jar and slf4j-simple.jar for logging if needed

A Maven Web Application is a project that includes not just Java classes but also supports the use of servlets, JSPs, and other web-related technologies. 
Since you want to develop a web-based application (likely with servlets for managing employee data and a database backend with Hibernate), a web application is the right type of project.

Create a New Maven Project:-
  -Open NetBeans and go to the File menu.
  -Select New Project.
  -In the dialog box, choose Java and then Maven.
  -Choose Web Application as the project type and click Next.
  -Set the Project Name and Project Location.
        -Project Name: EmployeeManagementApp
        -Project Location: Choose your desired directory for the project.
        -Group ID: com.employee
        -Artifact ID: EmployeeManagementApp
        -Version: 1.0-SNAPSHOT
  -Click Finish.
This creates the basic structure of your Maven web application project in NetBeans.

# Project Application structure:

EmployeeManagement/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.employee.model/
│   │   │   │   ├── Admin.java
│   │   │   │   └── Employee.java
│   │   │   ├── com.employee.dao/
│   │   │   │   ├── AdminDAO.java
│   │   │   │   └── EmployeeDAO.java
│   │   │   ├── com.employee.util/
│   │   │   │   └── HibernateUtil.java
│   │   │   └── com.employee.servlet/
│   │   │       ├── SignUpServlet.java
│   │   │       ├── LoginServlet.java
│   │   │       ├── AddEmployeeServlet.java
│   │   │       ├── EditEmployeeServlet.java
│   │   │       ├── DeleteEmployeeServlet.java
│   │   │       └── ShowEmployeesServlet.java
│   │   ├── resources/
│   │   │   └── hibernate.cfg.xml
│   │   └── webapp/
│       ├── index.jsp
│       ├── signup.jsp
│       ├── login.jsp
│       ├── welcome.jsp
│       ├── addEmployee.jsp
│       ├── editEmployee.jsp
│       ├── deleteEmployee.jsp
│       └── showEmployees.jsp
|── pom.xml





