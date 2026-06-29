# SaaS Tech Academy Assignments

This repository contains the completed technical deliverables for the SaaS Tech Academy certification. It includes a mix of custom Moqui framework components, Apache OFBiz plugins, and raw SQL data modeling queries based on the Moqui Universal Data Model (UDM).

## Repository Structure

### 📁 `Module 0/party`
**Summary:** Custom Moqui Party Component  
**Contents:** Contains the foundational Moqui component configurations (`component.xml`), entity definitions, UI screens, forms, and service logic for managing Party data (Persons, Organizations, and Roles), along with the MySQL database setup configurations.

### 📁 `Module 4/relationshipmgr`
**Summary:** OFBiz Relationship Manager Plugin  
**Contents:** Contains the OFBiz configurations, view-entities, and service logic designed to manage complex Party relationships and contact mechanisms within the OFBiz framework.

### 📁 `Module 5/productinformationmgr`
**Summary:** OFBiz Product Information Manager Plugin  
**Contents:** Contains the OFBiz implementation for product management, including entities and UI screens for managing Products, Product Features, and Product Categories based on the academy requirements.

### 📁 `Module 6/ordermgmtsystem`
**Summary:** Custom Moqui Order Management System Component  
**Contents:** Contains native Moqui Entity Engine definitions (`OrderEntities.xml` for OrderHeader, OrderItem, Adjustments, Payments), Moqui XML UI screens (`OrderScreens.xml`), and seed data (`SampleOrderData.xml`) for managing the order lifecycle.

### 📁 `Module 7/CustomerManagement`
**Summary:** OFBiz Find Customer Plugin  
**Contents:** Contains the `FindCustomerView` view-entity joining Party and Person data, Groovy service implementations (`CustomerServices.groovy`), event controllers, and the interactive UI screen (`findCustomer.ftl`) for searching and creating customers.

### 📁 `Module 7/ProductManagement`
**Summary:** OFBiz Find Product Plugin  
**Contents:** Contains the `FindProductView` view-entity, Groovy product CRUD services (`ProductServices.groovy`), event controllers, and the interactive UI screen (`findProduct.ftl`) for searching products by category and price range.

### 📁 `sql_assignments/`
**Summary:** Validated Moqui UDM SQL Queries  
**Contents:** Contains subfolders for `sql_assignment_1`, `sql_assignment_2`, and `sql_assignment_3`, holding the raw, validated MySQL queries for complex reporting, inventory tracking, order lifecycles, and appeasements based on the Moqui Universal Data Model.
