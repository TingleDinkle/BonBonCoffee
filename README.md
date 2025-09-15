# BonBonCoffee
Lebron Brand Coffee App

Literally what it is, yes. Coded in Netbeans and is connected to an SQL Database which I'm not sure how 2 upload here


Pretty dang cool

Here's the link to all the diagrams for this project: https://drive.google.com/file/d/17c8Nc03uZjd-ZBc57WcAlevTvrve23zp/view?usp=sharing

Use draw.io to see in more details
# How does it work?
# =============================================
# Programming Guidelines:
Feature Development
The project is developed in Java (NetBeans Maven project), using SQL Server.

The source code is organized according to the following structure:

- views: contains user interface forms (Swing)

- models: contains data classes (DTO)

- services: handles business logic and database queries

- images: contains image resources for the user interface

Adheres to the principle of separating the interface from business logic.
Variable names, classes, and methods must be clearly named; important code sections should include comments.
# Management:

- Invoices: (store invoices, print invoices, cancel invoices, manage the list of invoices).

- Orders: (view order list, update order status, cancel orders).

- Products & Menu: (add, edit, delete products in the menu, manage product categories).

- Customers: (manage customer information, manage membership cards, issue discount codes).

- Employees: (manage employee information, attendance tracking).

- Promotions & Discount Codes: (manage list of promotions, manage discount codes).

# Ordering & Payment at Counter:

- Employees place orders and process payments directly at the counter.

# Statistics:

- Revenue by day, month, year (total store revenue, revenue by product).

- Number of orders and customers over time (number of returning customers, orders during peak hours).

- Detailed invoice summaries and promotional programs (effectiveness of discount campaigns).

# Security:

- The software is designed for two types of users: managers and employees, with the following security requirements:

- All users must log in to use the system.

- Managers can perform all functions.

- Employees are not allowed to delete invoices or view revenue.

# Technology:

- The application must be developed on the Apache NetBeans platform.

- JDK: 23

- Database Management System: SQL Server 2022

# Interface design for functions:

- Load form:

   ![image alt](https://cdn.corenexis.com/view/8744935168)

