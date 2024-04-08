import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DATABASE_URL = "jdbc:sqlite:students_db.sqlite";

    private Connection connection;

    public DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL);
            createTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTables() throws SQLException {
        String createStudentsTable = "CREATE TABLE IF NOT EXISTS students (" +
                "student_id INTEGER PRIMARY KEY," +
                "first_name TEXT NOT NULL," +
                "last_name TEXT NOT NULL," +
                "address TEXT NOT NULL," +
                "phone_number TEXT," +
                "email TEXT NOT NULL," +
                "date_of_birth TEXT," +
                "password TEXT NOT NULL" +
                ");";
        PreparedStatement stmt = connection.prepareStatement(createStudentsTable);
        stmt.execute();
    }

    public void insertStudent(Student student) throws SQLException {
        String insertStudentSql = "INSERT INTO students (first_name, last_name, address, phone_number, email, date_of_birth, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(insertStudentSql);
        stmt.setString(1, student.getFirstName());
        stmt.setString(2, student.getLastName());
        stmt.setString(3, student.getAddress());
        stmt.setString(4, student.getPhoneNumber());
        stmt.setString(5, student.getEmail());
        stmt.setString(6, student.getDateOfBirth());
        stmt.setString(7, student.getPassword());
        stmt.executeUpdate();
    }

    public void updateStudent(Student student) throws SQLException {
        String updateStudentSql = "UPDATE students SET first_name = ?, last_name = ?, address = ?, phone_number = ?, password = ?, date_of_birth = ? WHERE student_id = ?";
        PreparedStatement stmt = connection.prepareStatement(updateStudentSql);
        stmt.setString(1, student.getFirstName());
        stmt.setString(2, student.getLastName());
        stmt.setString(3, student.getAddress());
        stmt.setString(4, student.getPhoneNumber());
        stmt.setString(5, student.getPassword());
        stmt.setString(6, student.getDateOfBirth());
        stmt.setInt(7, student.getId());
        stmt.executeUpdate();
    }

    public void deleteStudent(int studentId) throws SQLException {
        String deleteStudentSql = "DELETE FROM students WHERE student_id = ?";
        PreparedStatement stmt = connection.prepareStatement(deleteStudentSql);
        stmt.setInt(1, studentId);
        stmt.executeUpdate();
    }

    public Student getStudentByEmail(String email) throws SQLException {
        String getStudentSql = "SELECT * FROM students WHERE email = ?";
        PreparedStatement stmt = connection.prepareStatement(getStudentSql);
        stmt.setString(1, email);
        ResultSet resultSet = stmt.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("student_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String address = resultSet.getString("address");
            String phoneNumber = resultSet.getString("phone_number");
            String dateOfBirth = resultSet.getString("date_of_birth");
            String password = resultSet.getString("password");

            Student student = new Student(id, firstName, lastName, address, phoneNumber, email, dateOfBirth, password);
            return student;
        } else {
            return null;
        }
    }

    public Student getStudentByEmailAndPassword(String email, String password) throws SQLException {
        String query = "SELECT * FROM students WHERE email = ? AND password = ?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, email);
        stmt.setString(2, password);
        
        ResultSet resultSet = stmt.executeQuery();
        
        if (resultSet.next()) {
            int id = resultSet.getInt("student_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String address = resultSet.getString("address");
            String phoneNumber = resultSet.getString("phone_number");
            String dateOfBirth = resultSet.getString("date_of_birth");
            String userPassword = resultSet.getString("password");
            
            Student student = new Student(id, firstName, lastName, address, phoneNumber, email, dateOfBirth, userPassword);
            return student;
        } else {
            return null;
        }
    }
    
}
