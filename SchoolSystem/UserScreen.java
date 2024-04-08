 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserScreen {
    private StudentApp studentApp;
    private JFrame frmStudentScreen;
    private JPasswordField passwordField;
    private JTextField textField;
    private JTextField emailfield;
    private JPasswordField passwordfield;
    private JTextField firstnamefield;
    private JTextField lastnamefield;
    private JTextField addressfield;
    private JTextField dateofbirthfield;
    private JTextField phonenumberfield;
    
    public UserScreen(StudentApp studentApp, Student student) {
    	this.studentApp = studentApp;
    	frmStudentScreen = new JFrame();
    	frmStudentScreen.setResizable(false);
    	frmStudentScreen.setAlwaysOnTop(true);
    	frmStudentScreen.getContentPane().setLayout(null);
    	
    	JLabel lblNewLabel = new JLabel("email");
    	lblNewLabel.setBounds(64, 53, 71, 13);
    	frmStudentScreen.getContentPane().add(lblNewLabel);
    	
    	JLabel lblNewLabel_1 = new JLabel("password");
    	lblNewLabel_1.setBounds(64, 76, 71, 13);
    	frmStudentScreen.getContentPane().add(lblNewLabel_1);
    	
    	JLabel lblNewLabel_2 = new JLabel("First Name");
    	lblNewLabel_2.setBounds(64, 99, 71, 13);
    	frmStudentScreen.getContentPane().add(lblNewLabel_2);
    	
    	JLabel lblNewLabel_3 = new JLabel("Last Name");
    	lblNewLabel_3.setBounds(64, 122, 71, 13);
    	frmStudentScreen.getContentPane().add(lblNewLabel_3);
    	
    	JLabel lblNewLabel_4 = new JLabel("address");
    	lblNewLabel_4.setBounds(64, 145, 71, 13);
    	frmStudentScreen.getContentPane().add(lblNewLabel_4);
    	
    	JLabel lblNewLabel_5 = new JLabel("date of birth");
    	lblNewLabel_5.setBounds(64, 173, 71, 13);
    	frmStudentScreen.getContentPane().add(lblNewLabel_5);
    	
    	JLabel lblNewLabel_6 = new JLabel("phone number");
    	lblNewLabel_6.setBounds(64, 196, 71, 13);
    	frmStudentScreen.getContentPane().add(lblNewLabel_6);
    	
    	JLabel lblNewLabel_7 = new JLabel("User: " + student.getEmail());
    	lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 24));
    	lblNewLabel_7.setBounds(40, 10, 343, 29);
    	frmStudentScreen.getContentPane().add(lblNewLabel_7);
    	
    	emailfield = new JTextField();
    	emailfield.setEnabled(false);
    	emailfield.setEditable(false);
    	emailfield.setText(student.getEmail());
    	emailfield.setBounds(160, 50, 96, 19);
    	frmStudentScreen.getContentPane().add(emailfield);
    	emailfield.setColumns(10);
    	
    	passwordfield = new JPasswordField();
    	passwordfield.setText(student.getPassword());
    	passwordfield.setBounds(160, 73, 96, 19);
    	frmStudentScreen.getContentPane().add(passwordfield);
    	
    	firstnamefield = new JTextField();
    	firstnamefield.setText(student.getFirstName());
    	firstnamefield.setBounds(160, 96, 96, 19);
    	frmStudentScreen.getContentPane().add(firstnamefield);
    	firstnamefield.setColumns(10);
    	
    	lastnamefield = new JTextField();
    	lastnamefield.setText(student.getLastName());
    	lastnamefield.setBounds(160, 119, 96, 19);
    	frmStudentScreen.getContentPane().add(lastnamefield);
    	lastnamefield.setColumns(10);
    	
    	addressfield = new JTextField();
    	addressfield.setText(student.getAddress());
    	addressfield.setBounds(160, 145, 96, 19);
    	frmStudentScreen.getContentPane().add(addressfield);
    	addressfield.setColumns(10);
    	
    	dateofbirthfield = new JTextField();
    	dateofbirthfield.setText(student.getDateOfBirth());
    	dateofbirthfield.setBounds(160, 170, 96, 19);
    	frmStudentScreen.getContentPane().add(dateofbirthfield);
    	dateofbirthfield.setColumns(10);
    	
    	phonenumberfield = new JTextField();
    	phonenumberfield.setText(student.getPhoneNumber());
    	phonenumberfield.setBounds(160, 193, 96, 19);
    	frmStudentScreen.getContentPane().add(phonenumberfield);
    	phonenumberfield.setColumns(10);
    	frmStudentScreen.setSize(427, 298);
    	
    	JButton registerbutton = new JButton("Update");
    	registerbutton.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			String firstName = firstnamefield.getText();
    			String lastName = lastnamefield.getText();
    			String email = emailfield.getText();
				String password = new String(passwordfield.getPassword());
    			String address = addressfield.getText();
    			String phoneNumber = phonenumberfield.getText();
    			String dateOfBirth = dateofbirthfield.getText();
    			Student update = new Student(student.getId(), firstName, lastName, address, phoneNumber, email, dateOfBirth, password);
    			studentApp.updateStudent(update);
    		}
    	});
    	registerbutton.setBounds(100, 230, 85, 21);
    	frmStudentScreen.getContentPane().add(registerbutton);
    	
    	JButton deletebutton = new JButton("Delete User");
    	deletebutton.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			studentApp.deleteStudent(student.getId());
    			frmStudentScreen.dispose();
    			
    		}
    	});
    	deletebutton.setBounds(221, 230, 85, 21);
    	frmStudentScreen.getContentPane().add(deletebutton);
    	frmStudentScreen.setVisible(true);
    }
    
    
}
