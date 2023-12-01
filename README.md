# Patient Management System - Swing UI

## Overview
This Java Swing application implements a Patient Management System for a hospital, allowing users to add, query, and delete patient records. The UI is designed using the Swing UI designer, providing a user-friendly interface.

## Features
1. **Add Patient Record:** Users can input patient details, including ID, Name, State, City, Address, and Phone, and add them to the database.
2. **Query Patient Record:** Retrieve patient details based on the provided Patient ID.
3. **Delete Patient Record:** Remove a patient record from the database using the Patient ID.

## Technologies Used
- **Java Swing:** The graphical user interface is built using the Swing framework.
- **MySQL Database:** Patient records are stored and retrieved from a MySQL database.

## Usage
1. **Add Patient Record:**
   - Enter patient details in the respective text fields.
   - Click the "ADD" button to add the patient record to the database.

2. **Query Patient Record:**
   - Enter the Patient ID in the designated text field.
   - Click the "QUERY" button to retrieve and display the patient details.

3. **Delete Patient Record:**
   - Enter the Patient ID in the designated text field.
   - Click the "DELETE" button to remove the patient record from the database.

## Database Configuration
- The application connects to a MySQL database named "hospital2" on localhost at port 3306.
- Database connection parameters (username and password) are left blank in the code. Update them as per your MySQL setup.

## Running the Application
1. Compile and run the `patient_type2` class.
2. The Swing UI will appear, allowing you to interact with the Patient Management System.

## Dependencies
- Ensure that the MySQL JDBC driver is available in your project.

## License
This project is licensed under the [MIT License](LICENSE).

## Acknowledgments
- The UI design is created using the Swing UI designer.
- The application utilizes MySQL for database interactions.

Feel free to contribute to and enhance this Patient Management System. If you encounter issues or have suggestions, please open an issue in the repository.
