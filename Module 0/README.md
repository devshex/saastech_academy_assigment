# Module 0: Developing Application with Moqui (Custom Components)

During the initial days of the SaaS Tech Academy program, I successfully completed Module 0 by building custom Moqui components rather than just following the theoretical documentation. This directory contains the actual business logic, entities, and services I developed from scratch to master the Moqui architecture.

Here is a technical breakdown of the applications I developed:

## 1. `moqui-training` (Training Management App)
This component was my introduction to Moqui's Universal Data Model and Entity Engine.

### Data Model (Entities)
*   **`TrainingNote` Entity:** I designed an entity within the `moqui.training` package. 
    *   **Fields:** `trainingNoteId` (Primary Key), `noteText` (medium text), and `createdDate` (date-time).
    *   **Purpose:** To understand how Moqui dynamically creates tables in MySQL from XML definitions.

### Data Seeding
*   **`TrainingSecurityData.xml`**: I learned how to seed initial database records using Moqui's XML data loading mechanism, specifically focusing on security roles and permissions required to access the application.

## 2. `myPracticeApp` (Project Task Manager)
This component was a more advanced application focusing on standard CRUD operations for task management.

### Data Model (Entities)
*   **`ProjectTask` Entity:** I designed an entity within the `tutorial.project` package.
    *   **Fields:** `taskId` (Primary Key), `taskName`, `status` (short text), and `dueDate` (date).
    *   **Purpose:** To manage project deliverables and track their lifecycle statuses.

### Architectural Learnings Demonstrated
By building these components, I successfully demonstrated my ability to:
1.  **Structure a Moqui Component:** Correctly setting up the `component.xml` and organizing the `data`, `entity`, `screen`, and `service` directories.
2.  **Entity Definition:** Writing valid `entity-definition-3.xsd` compliant XML to model business domains.
3.  **Mantle Integration:** Understanding how custom components interact with the underlying Mantle business artifacts.

*These components serve as the foundation for the more complex Order Management System (OMS) and Party Data modeling completed in subsequent modules.*
