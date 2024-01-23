# Hotel-Management-System

## Overview

This is a simple Hotel Management System implemented in Java using Swing and AWT for the graphical user interface. The system allows hotel staff to manage customer information, room allocation, and other related tasks.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [How to Run the Application](#how-to-run-the-application)
- [Usage](#usage)
- [Notes](#notes)

## Technologies Used

- **Java Swing:** Used for creating the graphical user interface (GUI) components.
- **Java AWT:** Used for basic window handling and event management.
- **Java Database Connectivity (JDBC):** Used for database interaction.
- **MySQL Database:** Used as the backend database to store customer and room information.

## Project Structure

- **`HotelMangamentSystem.java`:** Main class that serves as the entry point for the Hotel Management System. It includes the initial welcome screen with animation and a "Next" button to proceed to the login screen.

- **`Dashboard.java`:** Class representing the main dashboard for the Hotel Management System. It includes options for reception and admin tasks.

- **`AddCustomer.java`:** Class for adding a new customer to the system. It includes a form to input customer details such as ID, name, gender, country, room number, check-in time, and deposit.
  
- **`AddCustomer.java`:** This class is responsible for adding new customers to the system. It includes a form to input customer details such as ID, name, gender, country, room number, check-in time, and deposit.

 - **`Room.java`:** This class displays information about the rooms, including room number, availability, status, price, and bed type. It utilizes the `DbUtils` library for displaying data in a JTable.

 - **`EmployeeInfo.java`:** This class presents information about employees, including name, age, gender, job, salary, phone, email, and Aadhar. It also utilizes the `DbUtils` library for displaying data in a JTable.

- **`AddRooms.java`:** This class allows the addition of new rooms to the system. It includes fields for room number, availability, cleaning status, price, and bed type.

  
## How to Run the Application

1. **Requirements:**
   - Java Development Kit (JDK) installed.
   - MySQL Database server installed.

2. **Database Setup:**
   - Create a MySQL database named `hotel_management`.
   - Execute the SQL script provided in the `database_script.sql` file to create the necessary tables.

3. **Compile and Run:**
   - Compile the Java files using the following commands in the terminal:
     ```bash
     javac *.java
     ```
   - Run the application using:
     ```bash
     java HotelMangamentSystem
     ```

4. **Usage:**
   - The application will open with a welcome screen. Click the "Next" button to proceed to the login screen.
   - Use the dashboard to perform various tasks related to customer management and room allocation.

5. **Screenshot:**
   - Hotel Management System
     
![Screenshot 2024-01-23 215012](https://github.com/anjaliraj7631/Hotel-Management-System/assets/97984325/dee3b11f-7bbb-4500-bb34-b4e5ee3fe8a8)

 - Dashboard
   
![Screenshot 2024-01-23 215056](https://github.com/anjaliraj7631/Hotel-Management-System/assets/97984325/ae71c321-8879-432c-a392-53ea4ef4d25c)

- Add Employees
  
![Screenshot 2024-01-23 215108](https://github.com/anjaliraj7631/Hotel-Management-System/assets/97984325/9874737c-abbd-42f3-b7ad-c01b5f917df8)

- Add Rooms
  
![Screenshot 2024-01-23 215123](https://github.com/anjaliraj7631/Hotel-Management-System/assets/97984325/194af97e-7137-44ce-87bf-f49cfeb45a0f)

- Reception
  
![Screenshot 2024-01-23 215140](https://github.com/anjaliraj7631/Hotel-Management-System/assets/97984325/58c86fe6-fad9-4739-a56e-c76b044830f6)

- Updated Room Status
  
![Screenshot 2024-01-23 215210](https://github.com/anjaliraj7631/Hotel-Management-System/assets/97984325/56b1b4e1-0288-4e18-bffb-d40dc51bcbb5)


## Notes

- This is a simple hotel management system for educational purposes.
- Make sure to update the database connection details in the code (`Conn` class) according to your MySQL server configuration.

Feel free to explore and enhance the functionality based on your requirements.
