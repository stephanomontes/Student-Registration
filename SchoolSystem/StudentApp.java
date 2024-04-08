
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class StudentApp {

    private DatabaseConnection dbConnection;
    private InitialScreen gui;

    public StudentApp() {
        dbConnection = new DatabaseConnection();
        gui = new InitialScreen(this);
    }

    public void registerStudent(String firstName, String lastName, String email, String address, String password) {
        Student student = new Student(firstName, lastName, email, password, address);
        insertStudent(student);
    }

    public void insertStudent(Student student) {
        try {
            dbConnection.insertStudent(student);
            JOptionPane.showMessageDialog(null, "Student successfully registered.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    
    public Student loginStudent(String email, String password) {
        try {
            return dbConnection.getStudentByEmailAndPassword(email, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return null;
        }
    }

    public void updateStudent(Student student) {
        try {
            dbConnection.updateStudent(student);
            JOptionPane.showMessageDialog(null, "Student information successfully updated.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteStudent(int studentId) {
        try {
            dbConnection.deleteStudent(studentId);
            JOptionPane.showMessageDialog(null, "Student successfully deleted.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }



    public static void main(String[] args) {
        new StudentApp();
    }
}
